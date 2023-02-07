package com.liu.service;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/16 10:55
 */

import com.baomidou.mybatisplus.extension.service.IService;
import com.liu.entity.Strategy;
import com.liu.vo.request.RequestWriteStrategyVo;
import com.liu.vo.response.ResponseAllStrategyListVo;
import com.liu.vo.response.ResponseStrategyListVo;
import com.liu.vo.response.ResponseUserStrategyVo;

import java.util.List;

public interface StrategyService extends IService<Strategy> {

    //查询全部攻略
    List<ResponseStrategyListVo> getStrategyList();

    //查询攻略
    List<ResponseStrategyListVo> findStrategyList(String title);

    //提交攻略
    void writeStrategy(RequestWriteStrategyVo requestWriteStrategyVo,Integer id);

    //用户个人攻略
    List<ResponseUserStrategyVo> getUserStrategyById(Integer userId);

    //查询全部攻略
    List<ResponseAllStrategyListVo> getAllStrategyList();

    //未过审攻略
    List<Strategy> getUnapprovedStrategyList();

    //审核中的攻略
    List<Strategy> getUnderReviewStrategyList();
}
