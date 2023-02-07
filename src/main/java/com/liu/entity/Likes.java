package com.liu.entity;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/21 12:28
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class Likes implements Serializable {

    @TableId(value = "likes_id",type = IdType.AUTO)
    private Integer id;

    @TableField(value = "user_id")
    private Integer userId;

    @TableField(value = "game_id")
    private Integer gameId;

    @TableField(value = "likes_time")
    private LocalDateTime likesTime;   //点赞时间
}
