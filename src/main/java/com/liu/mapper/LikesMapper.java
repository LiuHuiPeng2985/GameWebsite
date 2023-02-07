package com.liu.mapper;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/21 12:31
 */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liu.entity.Likes;
import com.liu.vo.response.ResponseUserGameLikesVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LikesMapper extends BaseMapper<Likes> {

    //查找是否被点赞
    @Select("select * from likes where user_id = #{userId} and game_id = #{gameId}")
    @Results(id = "likesMap",value = {
            @Result(id = true,column = "likes_id",property = "id"),
            @Result(column = "user_id",property = "userId"),
            @Result(column = "game_id",property = "gameId"),
            @Result(column = "likes_time",property = "likesTime")
    })
    Likes searchGameLikes(Integer userId,Integer gameId);

    //取消点赞
    @Delete("delete from likes where user_id = #{userId} and game_id = #{gameId}")
    @ResultMap("likesMap")
    void deleteLikes(Integer userId,Integer gameId);

    //用户的点赞
    @Select("select likes_id,likes.game_id,game_img,game_type,game_name,game_price,game_likes,likes_time from game, likes where game.game_id = likes.game_id and user_id = #{id}")
    @Results(id = "likes2Map",value = {
            @Result(id = true,column = "likes_id",property = "id"),
            @Result(column = "game_id",property = "gameId"),
            @Result(column = "game_img",property = "img"),
            @Result(column = "game_type",property = "type"),
            @Result(column = "game_name",property = "name"),
            @Result(column = "game_price",property = "price"),
            @Result(column = "game_likes",property = "likes"),
            @Result(column = "likes_time",property = "likesTime")
    })
    List<ResponseUserGameLikesVo> getGameLikesById(Integer id);

}
