package com.liu.controller;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/21 18:53
 */

import com.liu.common.Result;
import com.liu.service.CommentService;
import com.liu.vo.request.RequestSendCommentsVo;
import com.liu.vo.response.ResponseAllCommentListVo;
import com.liu.vo.response.ResponseCommentListVo;
import com.liu.vo.response.ResponseUserCommentVo;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    //单个游戏所有评论
    @GetMapping("/game/{id}")
    public Result gameComment(@PathVariable Integer id){
        List<ResponseCommentListVo> result = commentService.getCommentListById(id);
        return Result.getSuccess().setData(result);
    }

    //发表评论
    @PostMapping("/send")
    public Result send(@RequestBody RequestSendCommentsVo requestSendCommentsVo){
        commentService.sendComment(requestSendCommentsVo);
        return Result.getSuccess();
    }

    //用户评论
    @GetMapping("/all/{id}")
    public Result all(@PathVariable Integer id){
        List<ResponseUserCommentVo> result = commentService.getUserCommentById(id);
        return Result.getSuccess().setData(result);
    }

    //删除评论
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        commentService.removeById(id);
        return Result.getSuccess();
    }

    //全部评论
    @GetMapping("/allComment")
    public Result allComment(){
        List<ResponseAllCommentListVo> result = commentService.getAllCommentList();
        return Result.getSuccess().setData(result);
    }



}
