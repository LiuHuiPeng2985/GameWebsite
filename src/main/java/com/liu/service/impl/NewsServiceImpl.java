package com.liu.service.impl;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/24 21:42
 */

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liu.entity.News;
import com.liu.mapper.NewsMapper;
import com.liu.service.NewsService;
import com.liu.utils.DateUtils;
import com.liu.vo.request.RequestAddGameNewsVo;
import com.liu.vo.request.RequestUserMemberVo;
import com.liu.vo.request.RequestUserRechargeVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    //添加游戏消息
    @Override
    public void insertGameNews(RequestAddGameNewsVo requestAddGameNewsVo) {
        News news = new News();
        BeanUtils.copyProperties(requestAddGameNewsVo,news);
        Date date = new Date();
        news.setSendTime(DateUtils.getDateTimeOfTimestamp(date.getTime()));
        save(news);
    }

    //用户消息
    @Override
    public List<News> getUserNews(Integer id) {
        return newsMapper.getUserNews(id);
    }

    //添加充值消息
    @Override
    public void insertRechargeNews(RequestUserRechargeVo requestUserRechargeVo) {
        News news = new News();
        BeanUtils.copyProperties(requestUserRechargeVo,news);
        Date date = new Date();
        news.setSendTime(DateUtils.getDateTimeOfTimestamp(date.getTime()));
        save(news);
    }

    //添加会员消息
    @Override
    public void insertMemberNews(RequestUserMemberVo requestUserMemberVo) {
        News news = new News();
        BeanUtils.copyProperties(requestUserMemberVo,news);
        Date date = new Date();
        news.setSendTime(DateUtils.getDateTimeOfTimestamp(date.getTime()));
        save(news);
    }


}
