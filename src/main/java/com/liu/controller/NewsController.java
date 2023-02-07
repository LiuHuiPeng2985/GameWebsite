package com.liu.controller;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/24 21:34
 */

import com.liu.common.Result;
import com.liu.entity.Game;
import com.liu.entity.News;
import com.liu.entity.User;
import com.liu.service.GameService;
import com.liu.service.NewsService;
import com.liu.service.StorehouseService;
import com.liu.service.UserService;
import com.liu.utils.StringConsts;
import com.liu.vo.request.RequestAddGameNewsVo;
import com.liu.vo.request.RequestBuyGameVo;
import com.liu.vo.request.RequestUserMemberVo;
import com.liu.vo.request.RequestUserRechargeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private UserService userService;

    @Autowired
    private GameService gameService;

    @Autowired
    private StorehouseService storehouseService;

    //用户消息
    @GetMapping("/all/{id}")
    public Result all(@PathVariable Integer id){
        List<News> result = newsService.getUserNews(id);
        return Result.getSuccess().setData(result);
    }

    //充值
    @PostMapping("/recharge")
    public Result recharge(@RequestBody RequestUserRechargeVo requestUserRechargeVo){
        //添加充值消息
        requestUserRechargeVo.setNewsType(2);
        newsService.insertRechargeNews(requestUserRechargeVo);
        //更新用户余额
        User user = userService.getById(requestUserRechargeVo.getUserId());
        BigDecimal bigDecimal1 = user.getMoney();
        BigDecimal bigDecimal2 = bigDecimal1.add(requestUserRechargeVo.getRecharge());
        user.setMoney(bigDecimal2);
        userService.saveOrUpdate(user);
        return Result.getSuccess();
    }

    //开通会员
    @PostMapping("/member")
    public Result recharge(@RequestBody RequestBuyGameVo requestBuyGameVo){
        //更新游戏销量
        Game game = gameService.getById(requestBuyGameVo.getGameId());
        int sales = game.getSales() + 1;
        game.setSales(sales);
        gameService.saveOrUpdate(game);
        //添加会员消息
        RequestUserMemberVo requestUserMemberVo = new RequestUserMemberVo();
        requestUserMemberVo.setNewsType(3);
        requestUserMemberVo.setUserId(requestBuyGameVo.getUserId());
        newsService.insertMemberNews(requestUserMemberVo);
        //更新游戏仓库表
        storehouseService.insertGame(requestBuyGameVo);
        //更新用户身份及余额
        User user = userService.getById(requestBuyGameVo.getUserId());
        BigDecimal bigDecimal1 = user.getMoney();
        BigDecimal bigDecimal2 = bigDecimal1.subtract(BigDecimal.valueOf(500));
        user.setMoney(bigDecimal2);
        user.setIdentity(0);
        userService.saveOrUpdate(user);
        return Result.getSuccess();
    }
}
