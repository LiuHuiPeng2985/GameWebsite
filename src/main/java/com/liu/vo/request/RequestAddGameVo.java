package com.liu.vo.request;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/28 11:09
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class RequestAddGameVo {

    private String name;        //游戏名
    private BigDecimal price;   //游戏价格
    private Integer recommend;       //是否推荐(0：不推荐；1：推荐)
    private String edition;     //游戏版本介绍
    private String introduce;     //游戏介绍
    private String configFirst;     //游戏配置(操作系统)
    private String configSecond;     //游戏配置(处理器)
    private String configThird;     //游戏配置(显卡)
    private String configFourth;     //游戏配置(内存)
    private String configFifth;     //游戏配置(存储空间)
    private String  type;   //游戏类型

    private MultipartFile files[];

}
