package com.liu.service.impl;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/8 15:33
 */

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liu.entity.Game;
import com.liu.mapper.GameMapper;
import com.liu.service.GameService;
import com.liu.vo.response.ResponseGameListVo;
import com.liu.vo.response.ResponseGameRecommendationVo;
import com.liu.vo.response.ResponseGameUpdateVo;
import com.liu.vo.response.ResponseNewGameVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl extends ServiceImpl<GameMapper, Game> implements GameService {

    @Autowired
    private GameMapper gameMapper;

    //查询最新游戏
    @Override
    public List<ResponseNewGameVo> getNewGame() {
        return gameMapper.getNewGame();
    }

    //查询游戏推荐
    @Override
    public List<ResponseGameRecommendationVo> getGameRecommend() {
        return gameMapper.getGameRecommend();
    }

    //游戏更新列表
    @Override
    public List<ResponseGameUpdateVo> getGameUpdate() {
        return gameMapper.getGameUpdate();
    }

    //全部游戏(时间)
    @Override
    public List<ResponseGameListVo> getAllGameByTime() {
        return gameMapper.getAllGameByTime();
    }

    //全部游戏(点赞)
    @Override
    public List<ResponseGameListVo> getAllGameByLikes() {
        return gameMapper.getAllGameByLikes();
    }

    //全部游戏(推荐)
    @Override
    public List<ResponseGameListVo> getAllGameByRecommend() {
        return gameMapper.getAllGameByRecommend();
    }

    //游戏类型(时间)
    @Override
    public List<ResponseGameListVo> getGameByTime(String t) {
        return gameMapper.getGameByTime(t);
    }

    //游戏类型(点赞)
    @Override
    public List<ResponseGameListVo> getGameByLikes(String t) {
        return gameMapper.getGameByLikes(t);
    }

    //查找游戏(时间)
    @Override
    public List<ResponseGameListVo> findGameByTime(String t) {
        return gameMapper.findGameByTime(t);
    }

    //查找游戏(点赞)
    @Override
    public List<ResponseGameListVo> findGameByLikes(String t) {
        return gameMapper.findGameByLikes(t);
    }

    //全部游戏
    @Override
    public List<Game> getAllGameByName() {
        return gameMapper.getAllGameByName();
    }

    //全部游戏(价格)
    @Override
    public List<Game> getAllGameByMoney() {
        return gameMapper.getAllGameByMoney();
    }

    //全部游戏(销量)
    @Override
    public List<Game> getAllGameBySales() {
        return gameMapper.getAllGameBySales();
    }

    //游戏推荐
    @Override
    public List<Game> getAllGameByRecommends() {
        return gameMapper.getAllGameByRecommends();
    }

    //下架游戏
    @Override
    public List<Game> getAllGameByExist() {
        return gameMapper.getAllGameByExist();
    }


}
