package com.liu.entity;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/21 18:49
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
public class Comment implements Serializable {

    @TableId(value = "comment_id",type = IdType.AUTO)
    private Integer id;

    @TableField(value = "user_id")
    private Integer userId;

    @TableField(value = "game_id")
    private Integer gameId;

    @TableField(value = "comment_desc")
    private String commentDesc;     //评论内容

    @TableField(value = "comment_time")
    private LocalDateTime commentTime;   //点赞时间
}
