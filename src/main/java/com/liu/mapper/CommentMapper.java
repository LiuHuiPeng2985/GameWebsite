package com.liu.mapper;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/21 18:54
 */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liu.entity.Comment;
import com.liu.vo.response.ResponseAllCommentListVo;
import com.liu.vo.response.ResponseCommentListVo;
import com.liu.vo.response.ResponseUserCommentVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

    //单个游戏所有评论
    @Select("select user_name,user_identity,comment_desc,comment_time from user,comment where user.user_id = comment.user_id and comment.game_id = #{gameId} order by comment_time desc")
    @Results(id = "commentMap",value = {
            @Result(id = true,column = "comment_id",property = "id"),
            @Result(column = "user_name",property = "userName"),
            @Result(column = "user_identity",property = "userIdentity"),
            @Result(column = "comment_desc",property = "commentDesc"),
            @Result(column = "comment_time",property = "commentTime")
    })
    List<ResponseCommentListVo> getCommentListById(Integer gameId);

    //用户评论
    @Select("select comment_id,game_name,comment_desc,comment_time from comment,user,game where comment.game_id = game.game_id and comment.user_id = user.user_id and comment.user_id = #{id}")
    @Results(id = "comment1Map",value = {
            @Result(id = true,column = "comment_id",property = "id"),
            @Result(column = "user_id",property = "userId"),
            @Result(column = "game_id",property = "gameId"),
            @Result(column = "comment_desc",property = "commentDesc"),
            @Result(column = "comment_time",property = "commentTime")
    })
    List<ResponseUserCommentVo> getUserCommentById(Integer id);

    //全部评论
    @Select("select comment_id,comment.user_id,user.user_name,user.user_identity,game.game_name,comment_desc,comment_time from comment,user,game where user.user_id = comment.user_id and game.game_id = comment.game_id")
    @Results(id = "comment2Map",value = {
            @Result(id = true,column = "comment_id",property = "id"),
            @Result(column = "user_id",property = "userId"),
            @Result(column = "user_name",property = "userName"),
            @Result(column = "user_identity",property = "userIdentity"),
            @Result(column = "game_name",property = "gameName"),
            @Result(column = "comment_desc",property = "commentDesc"),
            @Result(column = "comment_time",property = "commentTime")
    })
    List<ResponseAllCommentListVo> getAllCommentList();

}
