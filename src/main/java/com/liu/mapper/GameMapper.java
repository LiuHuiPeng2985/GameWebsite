package com.liu.mapper;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/8 15:31
 */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liu.entity.Game;
import com.liu.vo.response.ResponseGameListVo;
import com.liu.vo.response.ResponseGameRecommendationVo;
import com.liu.vo.response.ResponseGameUpdateVo;
import com.liu.vo.response.ResponseNewGameVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GameMapper extends BaseMapper<Game> {

    //查询最新游戏
    @Select("select game_id,game_name,game_price,game_likes,game_edition,game_img,game_type,create_time from game where game_exist = 1 order by create_time desc limit 6")
    @Results(id = "gameMap",value = {
            @Result(id = true,column = "game_id",property = "id"),
            @Result(column = "game_name",property = "name"),
            @Result(column = "game_price",property = "price"),
            @Result(column = "game_likes",property = "likes"),
            @Result(column = "game_sales",property = "sales"),
            @Result(column = "game_recommend",property = "recommend"),
            @Result(column = "game_exist",property = "exist"),
            @Result(column = "game_edition",property = "edition"),
            @Result(column = "game_introduce",property = "introduce"),
            @Result(column = "game_config_first",property = "configFirst"),
            @Result(column = "game_config_second",property = "configSecond"),
            @Result(column = "game_config_third",property = "configThird"),
            @Result(column = "game_config_fourth",property = "configFourth"),
            @Result(column = "game_config_fifth",property = "configFifth"),
            @Result(column = "game_img",property = "img"),
            @Result(column = "game_screenshot_first",property = "screenshotFirst"),
            @Result(column = "game_screenshot_second",property = "screenshotSecond"),
            @Result(column = "game_screenshot_third",property = "screenshotThird"),
            @Result(column = "game_type",property = "type"),
            @Result(column = "create_time",property = "createTime")
    })
    List<ResponseNewGameVo> getNewGame();

    //查询游戏推荐
    @Select("select game_id,game_name,game_price,game_likes,game_edition,game_img,game_type,create_time from game where game_recommend = 1 and game_exist = 1 limit 10")
    @ResultMap("gameMap")
    List<ResponseGameRecommendationVo> getGameRecommend();

    //游戏更新列表
    @Select("select game_id,game_name,create_time from game where game_exist = 1 order by create_time desc")
    @ResultMap("gameMap")
    List<ResponseGameUpdateVo> getGameUpdate();

    //全部游戏(时间)
    @Select("select game_id,game_name,game_price,game_likes,game_edition,game_img,game_type,create_time from game where game_exist = 1 order by create_time desc")
    @ResultMap("gameMap")
    List<ResponseGameListVo> getAllGameByTime();

    //全部游戏(点赞)
    @Select("select game_id,game_name,game_price,game_likes,game_edition,game_img,game_type,create_time from game where game_exist = 1 order by game_likes desc")
    @ResultMap("gameMap")
    List<ResponseGameListVo> getAllGameByLikes();

    //全部游戏(推荐)
    @Select("select game_id,game_name,game_price,game_likes,game_edition,game_img,game_type,create_time from game where game_recommend = 1 and game_exist = 1")
    @ResultMap("gameMap")
    List<ResponseGameListVo> getAllGameByRecommend();

    //游戏类型(时间)
    @Select("select game_id,game_name,game_price,game_likes,game_edition,game_img,game_type,create_time from game where game_type = #{t} and game_exist = 1 order by create_time desc")
    @ResultMap("gameMap")
    List<ResponseGameListVo> getGameByTime(String t);

    //游戏类型(点赞)
    @Select("select game_id,game_name,game_price,game_likes,game_edition,game_img,game_type,create_time from game where game_type = #{t} and game_exist = 1 order by game_likes desc")
    @ResultMap("gameMap")
    List<ResponseGameListVo> getGameByLikes(String t);

    //查找游戏(时间)
    @Select("select game_id,game_name,game_price,game_likes,game_edition,game_img,game_type,create_time from game where game_name like concat('%',#{t},'%') and game_exist = 1 order by create_time desc")
    @ResultMap("gameMap")
    List<ResponseGameListVo> findGameByTime(String t);

    //查找游戏(点赞)
    @Select("select game_id,game_name,game_price,game_likes,game_edition,game_img,game_type,create_time from game where game_name like concat('%',#{t},'%') and game_exist = 1 order by game_likes desc")
    @ResultMap("gameMap")
    List<ResponseGameListVo> findGameByLikes(String t);

    //全部游戏
    @Select("select * from game order by game_name asc")
    @Results(id = "game1Map",value = {
            @Result(id = true,column = "game_id",property = "id"),
            @Result(column = "game_name",property = "name"),
            @Result(column = "game_price",property = "price"),
            @Result(column = "game_likes",property = "likes"),
            @Result(column = "game_sales",property = "sales"),
            @Result(column = "game_recommend",property = "recommend"),
            @Result(column = "game_exist",property = "exist"),
            @Result(column = "game_edition",property = "edition"),
            @Result(column = "game_introduce",property = "introduce"),
            @Result(column = "game_config_first",property = "configFirst"),
            @Result(column = "game_config_second",property = "configSecond"),
            @Result(column = "game_config_third",property = "configThird"),
            @Result(column = "game_config_fourth",property = "configFourth"),
            @Result(column = "game_config_fifth",property = "configFifth"),
            @Result(column = "game_img",property = "img"),
            @Result(column = "game_screenshot_first",property = "screenshotFirst"),
            @Result(column = "game_screenshot_second",property = "screenshotSecond"),
            @Result(column = "game_screenshot_third",property = "screenshotThird"),
            @Result(column = "game_type",property = "type"),
            @Result(column = "create_time",property = "createTime")
    })
    List<Game> getAllGameByName();

    //全部游戏(价格)
    @Select("select * from game order by game_price desc")
    @ResultMap("game1Map")
    List<Game> getAllGameByMoney();

    //全部游戏(销量)
    @Select("select * from game order by game_sales desc")
    @ResultMap("game1Map")
    List<Game> getAllGameBySales();

    //游戏推荐
    @Select("select * from game where game_recommend = 1")
    @ResultMap("game1Map")
    List<Game> getAllGameByRecommends();

    //下架游戏
    @Select("select * from game where game_exist = 0")
    @ResultMap("game1Map")
    List<Game> getAllGameByExist();
}
