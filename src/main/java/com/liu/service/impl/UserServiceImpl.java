package com.liu.service.impl;

/*
 * @author  LiuHuiPeng
 * @date    2022/5/25 10:56
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liu.entity.User;
import com.liu.mapper.UserMapper;
import com.liu.service.UserService;
import com.liu.utils.DateUtils;
import com.liu.utils.Md5Utils;
import com.liu.vo.request.RequestRegisterVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    //查询账号
    @Override
    public User queryByAccount(String account) {
        QueryWrapper<User> queryWrapper = new QueryWrapper <User>();
        queryWrapper.eq("user_account",account);
        User user = getOne(queryWrapper);
        return user;
    }

    //注册账号
    @Override
    public void register(RequestRegisterVo requestRegisterVo) {
        User user = new User();
        //拷贝类型一致，名称一致的属性
        BeanUtils.copyProperties(requestRegisterVo,user);
        user.setMoney(BigDecimal.valueOf(0.00));
        user.setIdentity(1);
        user.setType(1);
        user.setPassword(Md5Utils.hash(user.getPassword()));
        Date date = new Date();
        user.setCreateTime(DateUtils.getDateTimeOfTimestamp(date.getTime()));
        save(user);
    }

    //查询用户名
    @Override
    public User queryByName(String name) {
        QueryWrapper<User> queryWrapper = new QueryWrapper <User>();
        queryWrapper.eq("user_name",name);
        User user = getOne(queryWrapper);
        return user;
    }

    //全部用户
    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    //移除禁止时间
    @Override
    public void removeBanTime(Integer id) {
        userMapper.removeBanTime(id);
    }

    //查询会员
    @Override
    public List<User> getAllMemberUser() {
        return userMapper.getAllMemberUser();
    }

    //普通用户人数
    @Override
    public List<User> getAllOrdinaryUser() {
        return userMapper.getAllOrdinaryUser();
    }

    //封禁人数
    @Override
    public List<User> getAllViolationUser() {
        return userMapper.getAllViolationUser();
    }


}
