package com.liu.controller;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/20 17:26
 */

import com.liu.common.Result;
import com.liu.entity.Game;
import com.liu.entity.Storehouse;
import com.liu.entity.User;
import com.liu.service.GameService;
import com.liu.service.NewsService;
import com.liu.service.StorehouseService;
import com.liu.service.UserService;
import com.liu.utils.StringConsts;
import com.liu.vo.request.RequestAddGameNewsVo;
import com.liu.vo.request.RequestBuyGameVo;
import com.liu.vo.response.ResponseUserGameStorehouseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/storehouse")
public class StorehouseController {

    @Autowired
    private StorehouseService storehouseService;

    @Autowired
    private UserService userService;

    @Autowired
    private GameService gameService;

    @Autowired
    private NewsService newsService;

    //查找游戏
    @GetMapping("/exist")
    public Result exist(Integer userId,Integer gameId){
        Storehouse storehouse = storehouseService.gameStorehouseExist(userId,gameId);
        if (storehouse == null){
            return Result.getSuccess();
        }else {
            return Result.getFailure();
        }
    }

    //购买游戏
    @PostMapping("/buy")
    public Result buy(@RequestBody RequestBuyGameVo requestBuyGameVo){
        //查询用户余额
        User user = userService.getById(requestBuyGameVo.getUserId());
        BigDecimal bigDecimal1 = user.getMoney();
        //查询游戏售价
        Game game = gameService.getById(requestBuyGameVo.getGameId());
        BigDecimal bigDecimal2 = game.getPrice();
        int flag = bigDecimal1.compareTo(bigDecimal2);
        //1.当用户余额小于游戏售价时，游戏购买失败
        if (flag < 0){
            return Result.getFailure().setMsg(StringConsts.MONEY_NOT_ENOUGH);
        }
        //2.当用户余额大于等于游戏售价时，游戏购买成功
        else {
            //更新用户余额
            BigDecimal bigDecimal3 = bigDecimal1.subtract(bigDecimal2);
            user.setMoney(bigDecimal3);
            userService.saveOrUpdate(user);
            //更新游戏销量
            int sales = game.getSales() + 1;
            game.setSales(sales);
            gameService.saveOrUpdate(game);
            //更新游戏仓库表
            storehouseService.insertGame(requestBuyGameVo);
            //添加购买游戏消息
            RequestAddGameNewsVo requestAddGameNewsVo = new RequestAddGameNewsVo();
            requestAddGameNewsVo.setNewsType(1);
            requestAddGameNewsVo.setUserId(requestBuyGameVo.getUserId());
            requestAddGameNewsVo.setGameId(requestBuyGameVo.getGameId());
            newsService.insertGameNews(requestAddGameNewsVo);
            return Result.getSuccess().setMsg(StringConsts.BUY_SUCCESS);
        }
    }

    //游戏仓库
    @GetMapping("/all/{id}")
    public Result all(@PathVariable Integer id){
        List<ResponseUserGameStorehouseVo> result = storehouseService.getGameStorehouseById(id);
        return Result.getSuccess().setData(result);
    }

}
