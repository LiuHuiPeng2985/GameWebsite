package com.liu.mapper;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/20 17:27
 */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liu.entity.Storehouse;
import com.liu.vo.response.ResponseUserGameStorehouseVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StorehouseMapper extends BaseMapper<Storehouse> {

    //查找游戏
    @Select("select * from storehouse where user_id = #{userId} and game_id = #{gameId}")
    @Results(id = "storehouseMap",value = {
            @Result(id = true,column = "storehouse_id",property = "id"),
            @Result(column = "user_id",property = "userId"),
            @Result(column = "game_id",property = "gameId"),
            @Result(column = "buy_time",property = "buyTime")
    })
    Storehouse gameStorehouseExist(Integer userId,Integer gameId);

    //游戏仓库
    @Select("select storehouse_id,storehouse.game_id,game_img,game_type,game_name,game_price,buy_time from game, storehouse where game.game_id = storehouse.game_id and user_id = #{id}")
    @Results(id = "storehousesMap",value = {
            @Result(id = true,column = "storehouse_id",property = "id"),
            @Result(column = "game_id",property = "gameId"),
            @Result(column = "game_img",property = "img"),
            @Result(column = "game_type",property = "type"),
            @Result(column = "game_name",property = "name"),
            @Result(column = "game_price",property = "price"),
            @Result(column = "buy_time",property = "buyTime")
    })
    List<ResponseUserGameStorehouseVo> getGameStorehouseById(Integer id);

}
