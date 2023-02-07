package com.liu.entity;

/*
 * @author  LiuHuiPeng
 * @date    2022/5/25 9:27
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class User implements Serializable {

    @TableId(value = "user_id",type = IdType.AUTO)
    private Integer id;

    @TableField(value = "user_name")
    private String name;        //用户名

    @TableField(value = "user_account")
    private String account;     //账号

    @TableField(value = "user_password")
    private String password;    //密码

    @TableField(value = "user_money")
    private BigDecimal money;   //余额

    @TableField(value = "user_identity")
    private Integer identity;   //(0：VIP，1：非VIP)

    @TableField(value = "user_type")
    private Integer type;       //(0：管理员，1：用户)

    @TableField(value = "create_time")
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;   //创建时间

    @TableField(value = "ban_time")
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime banTime;      //封禁时间
}
