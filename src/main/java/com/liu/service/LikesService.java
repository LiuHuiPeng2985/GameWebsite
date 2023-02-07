package com.liu.service;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/21 12:32
 */

import com.baomidou.mybatisplus.extension.service.IService;
import com.liu.entity.Likes;
import com.liu.vo.request.RequestBuyGameVo;
import com.liu.vo.response.ResponseUserGameLikesVo;

import java.util.List;

public interface LikesService extends IService<Likes> {

    //查找是否被点赞
    Likes searchGameLikes(Integer userId,Integer gameId);

    //添加点赞数据
    void insertLikes(RequestBuyGameVo requestBuyGameVo);

    //取消点赞
    void deleteLikes(Integer userId,Integer gameId);

    //用户的点赞
    List<ResponseUserGameLikesVo> getGameLikesById(Integer id);

}
