package com.liu.service;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/21 18:54
 */

import com.baomidou.mybatisplus.extension.service.IService;
import com.liu.entity.Comment;
import com.liu.vo.request.RequestSendCommentsVo;
import com.liu.vo.response.ResponseAllCommentListVo;
import com.liu.vo.response.ResponseCommentListVo;
import com.liu.vo.response.ResponseUserCommentVo;

import java.util.List;

public interface CommentService extends IService<Comment> {

    //单个游戏所有评论
    List<ResponseCommentListVo> getCommentListById(Integer gameId);

    //发表评论
    void sendComment(RequestSendCommentsVo requestSendCommentsVo);

    //用户评论
    List<ResponseUserCommentVo> getUserCommentById(Integer id);

    //全部评论
    List<ResponseAllCommentListVo> getAllCommentList();
}
