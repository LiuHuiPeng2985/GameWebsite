package com.liu.service.impl;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/16 10:55
 */

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liu.entity.Strategy;
import com.liu.mapper.StrategyMapper;
import com.liu.service.StrategyService;
import com.liu.utils.DateUtils;
import com.liu.vo.request.RequestWriteStrategyVo;
import com.liu.vo.response.ResponseAllStrategyListVo;
import com.liu.vo.response.ResponseStrategyListVo;
import com.liu.vo.response.ResponseUserStrategyVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StrategyServiceImpl extends ServiceImpl<StrategyMapper, Strategy> implements StrategyService {

    @Autowired
    private StrategyMapper strategyMapper;

    //查询全部攻略
    @Override
    public List<ResponseStrategyListVo> getStrategyList() {
        return strategyMapper.getStrategyList();
    }

    //查询攻略
    @Override
    public List<ResponseStrategyListVo> findStrategyList(String title) {
        return strategyMapper.findStrategyList(title);
    }

    //提交攻略
    @Override
    public void writeStrategy(RequestWriteStrategyVo requestWriteStrategyVo,Integer id) {
        Strategy strategy = new Strategy();
        BeanUtils.copyProperties(requestWriteStrategyVo,strategy);
        strategy.setUserId(id);
        strategy.setPass(0);
        Date date = new Date();
        strategy.setStrategyCreateTime(DateUtils.getDateTimeOfTimestamp(date.getTime()));
        save(strategy);
    }

    //用户个人攻略
    @Override
    public List<ResponseUserStrategyVo> getUserStrategyById(Integer userId) {
        return strategyMapper.getUserStrategyById(userId);
    }

    //查询全部攻略
    @Override
    public List<ResponseAllStrategyListVo> getAllStrategyList() {
        return strategyMapper.getAllStrategyList();
    }

    //未过审攻略
    @Override
    public List<Strategy> getUnapprovedStrategyList() {
        return strategyMapper.getUnapprovedStrategyList();
    }

    //审核中的攻略
    @Override
    public List<Strategy> getUnderReviewStrategyList() {
        return strategyMapper.getUnderReviewStrategyList();
    }


}
