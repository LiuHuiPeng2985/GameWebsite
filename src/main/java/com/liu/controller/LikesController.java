package com.liu.controller;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/21 12:40
 */

import com.liu.common.Result;
import com.liu.entity.Game;
import com.liu.entity.Likes;
import com.liu.service.GameService;
import com.liu.service.LikesService;
import com.liu.service.UserService;
import com.liu.vo.request.RequestBuyGameVo;
import com.liu.vo.response.ResponseUserGameLikesVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/likes")
public class LikesController {

    @Autowired
    private LikesService likesService;

    @Autowired
    private UserService userService;

    @Autowired
    private GameService gameService;

    //查找是否被点赞
    @GetMapping("/exist")
    public Result exist(Integer userId,Integer gameId){
        Likes likes = likesService.searchGameLikes(userId, gameId);
        if (likes == null){
            return Result.getFailure();
        }else {
            return Result.getSuccess();
        }
    }

    //点赞
    @PostMapping("/up")
    public Result up(@RequestBody RequestBuyGameVo requestBuyGameVo){
        //更新游戏点赞量
        Game game = gameService.getById(requestBuyGameVo.getGameId());
        Integer l = game.getLikes() + 1;
        game.setLikes(l);
        gameService.saveOrUpdate(game);
        //添加点赞数据
        likesService.insertLikes(requestBuyGameVo);
        return Result.getSuccess();
    }

    //取消点赞
    @PostMapping("/down")
    public Result down(@RequestBody RequestBuyGameVo requestBuyGameVo){
        //更新游戏点赞量
        Game game = gameService.getById(requestBuyGameVo.getGameId());
        Integer l = game.getLikes() - 1;
        game.setLikes(l);
        gameService.saveOrUpdate(game);
        //删除点赞数据
        likesService.deleteLikes(requestBuyGameVo.getUserId(), requestBuyGameVo.getGameId());
        return Result.getSuccess();
    }

    //用户的点赞
    @GetMapping("/all/{id}")
    public Result all(@PathVariable Integer id){
        List<ResponseUserGameLikesVo> result = likesService.getGameLikesById(id);
        return Result.getSuccess().setData(result);
    }
}
