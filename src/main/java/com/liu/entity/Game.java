package com.liu.entity;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/4 11:30
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
public class Game implements Serializable {

    @TableId(value = "game_id",type = IdType.AUTO)
    private Integer id;

    @TableField(value = "game_name")
    private String name;        //游戏名

    @TableField(value = "game_price")
    private BigDecimal price;   //游戏价格

    @TableField(value = "game_likes")
    private Integer likes;       //游戏点赞数

    @TableField(value = "game_sales")
    private Integer sales;       //游戏销量

    @TableField(value = "game_recommend")
    private Integer recommend;       //是否推荐(0：不推荐；1：推荐)

    @TableField(value = "game_exist")
    private Integer exist;       //是否被下架(0：下架；1：上架)

    @TableField(value = "game_edition")
    private String edition;     //游戏版本介绍

    @TableField(value = "game_introduce")
    private String introduce;     //游戏介绍

    @TableField(value = "game_config_first")
    private String configFirst;     //游戏配置(操作系统)

    @TableField(value = "game_config_second")
    private String configSecond;     //游戏配置(处理器)

    @TableField(value = "game_config_third")
    private String configThird;     //游戏配置(显卡)

    @TableField(value = "game_config_fourth")
    private String configFourth;     //游戏配置(内存)

    @TableField(value = "game_config_fifth")
    private String configFifth;     //游戏配置(存储空间)

    @TableField(value = "game_img")
    private String img;     //游戏图片

    @TableField(value = "game_screenshot_first")
    private String screenshotFirst;     //游戏截图(一)

    @TableField(value = "game_screenshot_second")
    private String screenshotSecond;     //游戏截图(二)

    @TableField(value = "game_screenshot_third")
    private String screenshotThird;     //游戏截图(三)

    @TableField(value = "game_type")
    private String  type;   //游戏类型

    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;   //创建时间

}
