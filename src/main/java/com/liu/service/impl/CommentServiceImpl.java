package com.liu.service.impl;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/21 18:55
 */

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liu.entity.Comment;
import com.liu.mapper.CommentMapper;
import com.liu.service.CommentService;
import com.liu.utils.DateUtils;
import com.liu.vo.request.RequestSendCommentsVo;
import com.liu.vo.response.ResponseAllCommentListVo;
import com.liu.vo.response.ResponseCommentListVo;
import com.liu.vo.response.ResponseUserCommentVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    //单个游戏所有评论
    @Override
    public List<ResponseCommentListVo> getCommentListById(Integer gameId) {
        return commentMapper.getCommentListById(gameId);
    }

    //发表评论
    @Override
    public void sendComment(RequestSendCommentsVo requestSendCommentsVo) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(requestSendCommentsVo, comment);
        Date date = new Date();
        comment.setCommentTime(DateUtils.getDateTimeOfTimestamp(date.getTime()));
        save(comment);
    }

    //用户评论
    @Override
    public List<ResponseUserCommentVo> getUserCommentById(Integer id) {
        return commentMapper.getUserCommentById(id);
    }

    //全部评论
    @Override
    public List<ResponseAllCommentListVo> getAllCommentList() {
        return commentMapper.getAllCommentList();
    }
}
