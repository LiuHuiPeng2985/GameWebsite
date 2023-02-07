package com.liu.entity;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/20 17:03
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class Storehouse implements Serializable {

    @TableId(value = "storehouse_id",type = IdType.AUTO)
    private Integer id;

    @TableField(value = "user_id")
    private Integer userId;

    @TableField(value = "game_id")
    private Integer gameId;

    @TableField(value = "buy_time")
//    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime buyTime;   //购买时间
}
