package com.liu.mapper;

/*
 * @author  LiuHuiPeng
 * @date    2022/5/25 10:55
 */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liu.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    //全部用户
    @Select("select * from user")
    @Results(id = "userMap",value = {
            @Result(id = true,column = "user_id",property = "id"),
            @Result(column = "user_name",property = "name"),
            @Result(column = "user_account",property = "account"),
            @Result(column = "user_password",property = "password"),
            @Result(column = "user_money",property = "money"),
            @Result(column = "user_identity",property = "identity"),
            @Result(column = "user_type",property = "type"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "ban_time",property = "banTime")
    })
    List<User> getAllUser();

    //移除禁止时间
    @Update("update user set ban_time=null where user_id = #{id}")
    @ResultMap("userMap")
    void removeBanTime(Integer id);

    //查询会员
    @Select("select * from user where user_identity = 0")
    @ResultMap("userMap")
    List<User> getAllMemberUser();

    //普通用户人数
    @Select("select * from user where user_identity = 1")
    @ResultMap("userMap")
    List<User> getAllOrdinaryUser();

    //封禁人数
    @Select("select * from user where ban_time != null or ban_time != ''")
    @ResultMap("userMap")
    List<User> getAllViolationUser();
}
