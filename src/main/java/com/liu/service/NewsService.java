package com.liu.service;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/24 21:41
 */

import com.baomidou.mybatisplus.extension.service.IService;
import com.liu.entity.News;
import com.liu.vo.request.RequestAddGameNewsVo;
import com.liu.vo.request.RequestUserMemberVo;
import com.liu.vo.request.RequestUserRechargeVo;

import java.util.List;

public interface NewsService extends IService<News> {

    //添加游戏消息
    void insertGameNews(RequestAddGameNewsVo requestAddGameNewsVo);

    //用户消息
    List<News> getUserNews(Integer id);

    //添加充值消息
    void insertRechargeNews(RequestUserRechargeVo requestUserRechargeVo);

    //添加会员消息
    void insertMemberNews(RequestUserMemberVo requestUserMemberVo);
}
