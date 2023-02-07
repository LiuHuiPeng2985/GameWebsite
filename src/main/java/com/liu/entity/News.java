package com.liu.entity;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/22 21:03
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
public class News implements Serializable {

    @TableId(value = "news_id",type = IdType.AUTO)
    private Integer id;

    @TableField(value = "news_type")
    private Integer newsType;         //推送类型(1：购买游戏；2：充值；3：开通VIP)

    @TableField(value = "user_id")
    private Integer userId;          //接收者

    @TableField(value = "game_id")
    private Integer gameId;          //购买的游戏

    @TableField(value = "recharge")
    private BigDecimal recharge;    //充值的金额

    @TableField(value = "send_time")
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime sendTime;   //发送时间

}
