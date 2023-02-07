package com.liu.service;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/8 15:32
 */

import com.baomidou.mybatisplus.extension.service.IService;
import com.liu.entity.Game;
import com.liu.vo.response.ResponseGameListVo;
import com.liu.vo.response.ResponseGameRecommendationVo;
import com.liu.vo.response.ResponseGameUpdateVo;
import com.liu.vo.response.ResponseNewGameVo;

import java.util.List;

public interface GameService extends IService<Game> {

    //查询最新游戏
    List<ResponseNewGameVo> getNewGame();

    //查询游戏推荐
    List<ResponseGameRecommendationVo> getGameRecommend();

    //游戏更新列表
    List<ResponseGameUpdateVo> getGameUpdate();

    //全部游戏(时间)
    List<ResponseGameListVo> getAllGameByTime();

    //全部游戏(点赞)
    List<ResponseGameListVo> getAllGameByLikes();

    //全部游戏(推荐)
    List<ResponseGameListVo> getAllGameByRecommend();

    //游戏类型(时间)
    List<ResponseGameListVo> getGameByTime(String t);

    //游戏类型(点赞)
    List<ResponseGameListVo> getGameByLikes(String t);

    //查找游戏(时间)
    List<ResponseGameListVo> findGameByTime(String t);

    //查找游戏(点赞)
    List<ResponseGameListVo> findGameByLikes(String t);

    //全部游戏
    List<Game> getAllGameByName();

    //全部游戏(价格)
    List<Game> getAllGameByMoney();

    //全部游戏(销量)
    List<Game> getAllGameBySales();

    //游戏推荐
    List<Game> getAllGameByRecommends();

    //下架游戏
    List<Game> getAllGameByExist();
}
