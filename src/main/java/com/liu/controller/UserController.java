package com.liu.controller;

/*
 * @author  LiuHuiPeng
 * @date    2022/7/28 14:22
 */

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.liu.common.Result;
import com.liu.entity.User;
import com.liu.service.UserService;
import com.liu.utils.DateUtils;
import com.liu.utils.Md5Utils;
import com.liu.utils.StringConsts;
import com.liu.vo.request.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //登录
    @PostMapping("/login")
    public Result login(@RequestBody RequestLoginVo requestLoginVo){
        //判断用户账号是否存在
        User user = userService.queryByAccount(requestLoginVo.getAccount());
        if (ObjectUtils.isEmpty(user)){
            return Result.getFailure().setMsg(StringConsts.USER_NOT_EXIST);
        }
        //判断密码是否正确
        if (!Md5Utils.hash(requestLoginVo.getPassword()).equals(user.getPassword())){
            return Result.getFailure().setMsg(StringConsts.PASSWORD_ERROR);
        }
        //设置的时间
        LocalDateTime dateTime = user.getBanTime();
        if (dateTime == null){
            Map<String ,Object> data = new HashMap<>();
            data.put("userId",user.getId());
            data.put("isUser",user.getType());
            return Result.getSuccess().setData(data);
        }
        //禁止的时间在现在时间的后面，为false
        if (dateTime.isBefore(LocalDateTime.now()) == false){
            return Result.getFailure().setMsg(StringConsts.USER_BAN);
        }
        //判断角色，isUser==true:用户
        Map<String ,Object> data = new HashMap<>();
        data.put("userId",user.getId());
        data.put("isUser",user.getType());
        return Result.getSuccess().setData(data);
    }

    //注册
    @PostMapping("/register")
    public Result register(@RequestBody RequestRegisterVo requestRegisterVo){
        //判断用户名是否已被使用
        User user1 = userService.queryByName(requestRegisterVo.getName());
        if (ObjectUtils.isNotEmpty(user1)){
            return Result.getFailure().setMsg(StringConsts.NAME_IS_EXIST);
        }
        //判断账号是否被注册
        User user = userService.queryByAccount(requestRegisterVo.getAccount());
        if (ObjectUtils.isNotEmpty(user)){
            return Result.getFailure().setMsg(StringConsts.ACCOUNT_IS_EXIST);
        }
        userService.register(requestRegisterVo);
        return Result.getSuccess().setMsg(StringConsts.REGISTER_SUCCESS);
    }

    //主页个人信息
    @GetMapping("/information/{id}")
    public Result information(@PathVariable Integer id){
        User user = userService.getById(id);
        return Result.getSuccess().setData(user);
    }

    //编辑用户名
    @PutMapping("/edit")
    public Result edit(@RequestBody RequestEditUserNameVo requestEditUserNameVo){
        User user = userService.getById(requestEditUserNameVo.getUserId());
        user.setName(requestEditUserNameVo.getUserName());
        userService.saveOrUpdate(user);
        return Result.getSuccess();
    }

    //修改密码
    @PostMapping("/password")
    public Result password(@RequestBody RequestUpdatePasswordVo requestUpdatePasswordVo){
        User user = userService.getById(requestUpdatePasswordVo.getUserId());
        //判断密码是否正确
        if (!Md5Utils.hash(requestUpdatePasswordVo.getOldPassword()).equals(user.getPassword())){
            return Result.getFailure().setMsg(StringConsts.PASSWORD_ERROR);
        }
        user.setPassword(Md5Utils.hash(requestUpdatePasswordVo.getPassword()));
        userService.saveOrUpdate(user);
        return Result.getSuccess().setMsg(StringConsts.PASSWORD_SUCCESS);
    }

    //查询全部用户
    @GetMapping("/allUser")
    public Result allUser(){
        List<User> result = userService.getAllUser();
        return Result.getSuccess().setData(result);
    }

    //添加封禁时间
    @PostMapping("/addBan")
    public Result addBan(@RequestBody RequestUserBanTimeVo requestUserBanTimeVo){
        User user = userService.getById(requestUserBanTimeVo.getId());
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(requestUserBanTimeVo.getBanTime(),df);
        user.setBanTime(localDateTime);
        userService.saveOrUpdate(user);
        return Result.getSuccess();
    }

    //解除封禁时间
    @DeleteMapping("/deleteBan/{id}")
    public Result deleteBan(@PathVariable Integer id){
        userService.removeBanTime(id);
        return Result.getSuccess();
    }

    //查询会员
    @GetMapping("/member")
    public Result member(){
        List<User> result = userService.getAllMemberUser();
        return Result.getSuccess().setData(result);
    }

    //普通用户人数
    @GetMapping("/ordinary")
    public Result ordinary(){
        List<User> result = userService.getAllOrdinaryUser();
        return Result.getSuccess().setData(result);
    }

    //封禁人数
    @GetMapping("/violation")
    public Result violation(){
        List<User> result = userService.getAllViolationUser();
        return Result.getSuccess().setData(result);
    }

    //查询账户
    @GetMapping("/account/{acc}")
    public Result account(@PathVariable String acc){
        User user =userService.queryByAccount(acc);
        return Result.getSuccess().setData(user);
    }
}
