package com.liu.controller;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/16 10:55
 */

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.liu.common.Result;
import com.liu.entity.Strategy;
import com.liu.entity.User;
import com.liu.service.StrategyService;
import com.liu.utils.StringConsts;
import com.liu.vo.request.RequestFindStrategyListVo;
import com.liu.vo.request.RequestWriteStrategyVo;
import com.liu.vo.response.ResponseAllStrategyListVo;
import com.liu.vo.response.ResponseStrategyListVo;
import com.liu.vo.response.ResponseUserStrategyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/strategy")
public class StrategyController {

    @Autowired
    private StrategyService strategyService;

    //全部攻略
    @GetMapping("/list")
    public Result list(){
        List<ResponseStrategyListVo> result = strategyService.getStrategyList();
        return Result.getSuccess().setData(result);
    }

    //查找攻略
    @GetMapping("/find/{title}")
    public Result find(RequestFindStrategyListVo requestFindStrategyListVo){
        String title = requestFindStrategyListVo.getTitle();
        List<ResponseStrategyListVo> result = strategyService.findStrategyList(title);
        return Result.getSuccess().setData(result);
    }

    //提交攻略
    @PostMapping("/write/{id}")
    public Result write(@RequestBody RequestWriteStrategyVo requestWriteStrategyVo, @PathVariable Integer id){
        strategyService.writeStrategy(requestWriteStrategyVo,id);
        return Result.getSuccess().setMsg(StringConsts.STRATEGY_SUBMIT_SUCCESS);
    }

    //用户个人攻略
    @GetMapping("/all/{userId}")
    public Result all(@PathVariable Integer userId){
        List<ResponseUserStrategyVo> result = strategyService.getUserStrategyById(userId);
        return Result.getSuccess().setData(result);
    }

    //攻略详情
    @GetMapping("/desc/{id}")
    public Result desc(@PathVariable Integer id){
        Strategy strategy = strategyService.getById(id);
        return Result.getSuccess().setData(strategy);
    }

    //删除攻略
    @GetMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        strategyService.removeById(id);
        return Result.getSuccess();
    }

    //全部攻略(管理员)
    @GetMapping("/allStrategy")
    public Result allStrategy(){
        List<ResponseAllStrategyListVo> result = strategyService.getAllStrategyList();
        return Result.getSuccess().setData(result);
    }

    //未过审攻略
    @GetMapping("/unapproved")
    public Result unapproved(){
        List<Strategy> result = strategyService.getUnapprovedStrategyList();
        return Result.getSuccess().setData(result);
    }

    //审核中的攻略
    @GetMapping("/underReview")
    public Result underReview(){
        List<Strategy> result = strategyService.getUnderReviewStrategyList();
        return Result.getSuccess().setData(result);
    }

    //通过审核
    @PutMapping("/adopt/{id}")
    public Result adopt(@PathVariable Integer id){
        Strategy strategy = strategyService.getById(id);
        strategy.setPass(1);
        strategyService.saveOrUpdate(strategy);
        return Result.getSuccess();
    }

    //取消审核
    @PutMapping("/noAdopt/{id}")
    public Result noAdopt(@PathVariable Integer id){
        Strategy strategy = strategyService.getById(id);
        strategy.setPass(2);
        strategyService.saveOrUpdate(strategy);
        return Result.getSuccess();
    }

}
