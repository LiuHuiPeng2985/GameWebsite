package com.liu.service.impl;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/21 12:34
 */

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liu.entity.Likes;
import com.liu.mapper.LikesMapper;
import com.liu.service.LikesService;
import com.liu.utils.DateUtils;
import com.liu.vo.request.RequestBuyGameVo;
import com.liu.vo.response.ResponseUserGameLikesVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LikesServiceImpl extends ServiceImpl<LikesMapper, Likes> implements LikesService {

    @Autowired
    private LikesMapper likesMapper;

    //查找是否被点赞
    @Override
    public Likes searchGameLikes(Integer userId, Integer gameId) {
        return likesMapper.searchGameLikes(userId,gameId);
    }

    //添加点赞数据
    @Override
    public void insertLikes(RequestBuyGameVo requestBuyGameVo) {
        Likes likes = new Likes();
        BeanUtils.copyProperties(requestBuyGameVo, likes);
        Date date = new Date();
        likes.setLikesTime(DateUtils.getDateTimeOfTimestamp(date.getTime()));
        save(likes);
    }

    //取消点赞
    @Override
    public void deleteLikes(Integer userId, Integer gameId) {
        likesMapper.deleteLikes(userId, gameId);
    }

    //用户的点赞
    @Override
    public List<ResponseUserGameLikesVo> getGameLikesById(Integer id) {
        return likesMapper.getGameLikesById(id);
    }
}
