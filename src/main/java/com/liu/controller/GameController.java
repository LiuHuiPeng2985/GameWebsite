package com.liu.controller;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/4 16:58
 */

import com.liu.common.Result;
import com.liu.entity.Game;
import com.liu.service.GameService;
import com.liu.utils.DateUtils;
import com.liu.vo.request.RequestAddGameVo;
import com.liu.vo.response.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    //最新游戏
    @GetMapping("/newest")
    public Result newest(){
        List<ResponseNewGameVo> result = gameService.getNewGame();
        return Result.getSuccess().setData(result);
    }

    //推荐游戏
    @GetMapping("/recommendation")
    public Result recommendation(){
        List<ResponseGameRecommendationVo> result = gameService.getGameRecommend();
        return Result.getSuccess().setData(result);
    }

    //游戏更新列表
    @GetMapping("/update")
    public Result update(){
        List<ResponseGameUpdateVo> result = gameService.getGameUpdate();
        return Result.getSuccess().setData(result);
    }

    //全部游戏(时间)
    @GetMapping("/all/time")
    public Result allTime(){
        List<ResponseGameListVo> result = gameService.getAllGameByTime();
        return Result.getSuccess().setData(result);
    }

    //全部游戏(点赞)
    @GetMapping("/all/likes")
    public Result allLikes(){
        List<ResponseGameListVo> result = gameService.getAllGameByLikes();
        return Result.getSuccess().setData(result);
    }

    //全部游戏(推荐)
    @GetMapping("/all/recommend")
    public Result allRecommend(){
        List<ResponseGameListVo> result = gameService.getAllGameByRecommend();
        return Result.getSuccess().setData(result);
    }

    //根据游戏类型显示游戏(时间)
    @GetMapping("/type/time/{t}")
    public Result typeTime(@PathVariable String t){
        List<ResponseGameListVo> result = gameService.getGameByTime(t);
        return Result.getSuccess().setData(result);
    }

    //根据游戏类型显示游戏(点赞)
    @GetMapping("/type/likes/{t}")
    public Result typeLikes(@PathVariable String t){
        List<ResponseGameListVo> result = gameService.getGameByLikes(t);
        return Result.getSuccess().setData(result);
    }

    //查找游戏(时间)
    @GetMapping("/find/time/{t}")
    public Result findTime(@PathVariable String t){
        List<ResponseGameListVo> result = gameService.findGameByTime(t);
        return Result.getSuccess().setData(result);
    }

    //查找游戏(点赞)
    @GetMapping("/find/likes/{t}")
    public Result findLikes(@PathVariable String t){
        List<ResponseGameListVo> result = gameService.findGameByLikes(t);
        return Result.getSuccess().setData(result);
    }

    //游戏详情
    @GetMapping("/details/{id}")
    public Result details(@PathVariable Integer id){
        Game game = gameService.getById(id);
        return Result.getSuccess().setData(game);
    }

    //全部游戏
    @GetMapping("/name")
    public Result name(){
        List<Game> result = gameService.getAllGameByName();
        return Result.getSuccess().setData(result);
    }

    //全部游戏(价格)
    @GetMapping("/money")
    public Result money(){
        List<Game> result = gameService.getAllGameByMoney();
        return Result.getSuccess().setData(result);
    }

    //全部游戏(销量)
    @GetMapping("/sales")
    public Result sales(){
        List<Game> result = gameService.getAllGameBySales();
        return Result.getSuccess().setData(result);
    }

    //游戏推荐
    @GetMapping("/recommend")
    public Result recommend(){
        List<Game> result = gameService.getAllGameByRecommends();
        return Result.getSuccess().setData(result);
    }

    //下架游戏
    @GetMapping("/notExist")
    public Result notExist(){
        List<Game> result = gameService.getAllGameByExist();
        return Result.getSuccess().setData(result);
    }

    //修改游戏基础数据
    @PostMapping("/basics")
    public Result basics(@RequestBody Game game){
        Game game1 = gameService.getById(game.getId());
        BeanUtils.copyProperties(game, game1);
        gameService.saveOrUpdate(game1);
        return Result.getSuccess();
    }

    //上架游戏
    @PostMapping("/addGame")
    public Result addGame(RequestAddGameVo requestAddGameVo){
        Game game = new Game();
        //表单
        game.setName(requestAddGameVo.getName());
        game.setPrice(requestAddGameVo.getPrice());
        game.setRecommend(requestAddGameVo.getRecommend());
        game.setEdition(requestAddGameVo.getEdition());
        game.setIntroduce(requestAddGameVo.getIntroduce());
        game.setConfigFirst(requestAddGameVo.getConfigFirst());
        game.setConfigSecond(requestAddGameVo.getConfigSecond());
        game.setConfigThird(requestAddGameVo.getConfigThird());
        game.setConfigFourth(requestAddGameVo.getConfigFourth());
        game.setConfigFifth(requestAddGameVo.getConfigFifth());
        game.setType(requestAddGameVo.getType());
        //默认
        game.setLikes(0);
        game.setSales(0);
        game.setExist(1);
        Date date = new Date();
        game.setCreateTime(DateUtils.getDateTimeOfTimestamp(date.getTime()));
        //图片
        MultipartFile multipartFile = requestAddGameVo.getFiles()[0];
        MultipartFile multipartFile1 = requestAddGameVo.getFiles()[1];
        MultipartFile multipartFile2 = requestAddGameVo.getFiles()[2];
        MultipartFile multipartFile3 = requestAddGameVo.getFiles()[3];
        String name = multipartFile.getOriginalFilename();
        String name1 = multipartFile1.getOriginalFilename();
        String name2 = multipartFile2.getOriginalFilename();
        String name3 = multipartFile2.getOriginalFilename();
        game.setImg("../img/game/"+name);
        game.setScreenshotFirst("../img/screenshot/"+name1);
        game.setScreenshotSecond("../img/screenshot/"+name2);
        game.setScreenshotThird("../img/screenshot/"+name3);
        gameService.saveOrUpdate(game);
        return Result.getSuccess();
    }



}
