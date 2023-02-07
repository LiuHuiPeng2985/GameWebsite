package com.liu.service;

/*
 * @author  LiuHuiPeng
 * @date    2022/5/25 10:55
 */

import com.baomidou.mybatisplus.extension.service.IService;
import com.liu.entity.User;
import com.liu.vo.request.RequestRegisterVo;

import java.util.List;

public interface UserService extends IService<User> {

    //查询账号
    User queryByAccount(String account);

    //注册账号
    void register(RequestRegisterVo requestRegisterVo);

    //查询用户名
    User queryByName(String name);

    //全部用户
    List<User> getAllUser();

    //移除禁止时间
    void removeBanTime(Integer id);

    //查询会员
    List<User> getAllMemberUser();

    //普通用户人数
    List<User> getAllOrdinaryUser();

    //封禁人数
    List<User> getAllViolationUser();
}
