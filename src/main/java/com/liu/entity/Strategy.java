package com.liu.entity;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/16 10:51
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class Strategy implements Serializable {

    @TableId(value = "strategy_id",type = IdType.AUTO)
    private Integer id;

    @TableField(value = "user_id")
    private Integer userId;

    @TableField(value = "strategy_title")
    private String title;     //攻略标题

    @TableField(value = "strategy_content")
    private String content;    //攻略内容

    @TableField(value = "strategy_game")
    private String game;   //攻略游戏

    @TableField(value = "strategy_pass")
    private Integer pass;   //是否通过审核(0：审核中；1：通过；2：未通过)

    @TableField(value = "strategy_create_time")
    private LocalDateTime strategyCreateTime;   //创建时间

}
