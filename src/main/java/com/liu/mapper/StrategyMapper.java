package com.liu.mapper;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/16 10:55
 */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liu.entity.Strategy;
import com.liu.vo.response.ResponseAllStrategyListVo;
import com.liu.vo.response.ResponseStrategyListVo;
import com.liu.vo.response.ResponseUserStrategyVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StrategyMapper extends BaseMapper<Strategy> {

    //查询全部攻略
    @Select("select strategy_id,user_name,user_identity,strategy_title,strategy_content,strategy_game,strategy_create_time from user,strategy where user.user_id = strategy.user_id and strategy.strategy_pass = 1 order by strategy_create_time desc")
    @ResultMap("strategy2Map")
    List<ResponseStrategyListVo> getStrategyList();

    //查询全部攻略
    @Select("select strategy_id,user_name,user_identity,strategy_title,strategy_content,strategy_game,strategy_create_time from user,strategy where user.user_id = strategy.user_id and strategy.strategy_pass = 1 and strategy_title like concat('%',#{title},'%') order by strategy_create_time desc")
    @ResultMap("strategy2Map")
    List<ResponseStrategyListVo> findStrategyList(String title);

    //用户个人攻略
    @Select("select strategy_id,strategy_title,strategy_content,strategy_game,strategy_pass,strategy_create_time from strategy where user_id = #{userId}")
    @Results(id = "strategy1Map",value = {
            @Result(id = true,column = "strategy_id",property = "id"),
            @Result(column = "user_id",property = "userId"),
            @Result(column = "strategy_title",property = "title"),
            @Result(column = "strategy_content",property = "content"),
            @Result(column = "strategy_game",property = "game"),
            @Result(column = "strategy_pass",property = "pass"),
            @Result(column = "strategy_create_time",property = "strategyCreateTime")
    })
//    @ResultMap("strategyMap")
//    There is no setter for property named 'game' in 'class com.liu.vo.response.ResponseStrategyListVo'
    List<ResponseUserStrategyVo> getUserStrategyById(Integer userId);

    //查询全部攻略
    @Select("select strategy_id,user.user_name,user.user_identity,strategy_title,strategy_content,strategy_game,strategy_pass,strategy_create_time from strategy,user where strategy.user_id = user.user_id")
    @Results(id = "strategy2Map",value = {
            @Result(id = true,column = "strategy_id",property = "id"),
            @Result(column = "user_name",property = "userName"),
            @Result(column = "user_identity",property = "userIdentity"),
            @Result(column = "strategy_title",property = "title"),
            @Result(column = "strategy_content",property = "content"),
            @Result(column = "strategy_game",property = "game"),
            @Result(column = "strategy_pass",property = "pass"),
            @Result(column = "strategy_create_time",property = "strategyCreateTime")
    })
    List<ResponseAllStrategyListVo> getAllStrategyList();

    //未过审攻略
    @Select("select * from strategy where strategy_pass = 2")
    @Results(id = "strategyMap",value = {
            @Result(id = true,column = "strategy_id",property = "id"),
            @Result(column = "user_id",property = "userId"),
            @Result(column = "strategy_title",property = "title"),
            @Result(column = "strategy_content",property = "content"),
            @Result(column = "strategy_game",property = "game"),
            @Result(column = "strategy_pass",property = "pass"),
            @Result(column = "strategy_create_time",property = "strategyCreateTime")
    })
    List<Strategy> getUnapprovedStrategyList();

    //审核中的攻略
    @Select("select * from strategy where strategy_pass = 0")
    @ResultMap("strategyMap")
    List<Strategy> getUnderReviewStrategyList();
}
