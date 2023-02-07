package com.liu.vo.response;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/9 13:03
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ResponseGameRecommendationVo {

    private Integer id;
    private String img;
    private String type;
    private String name;
    private String edition;     //游戏版本介绍
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;   //创建时间
    private Integer likes;  //点赞数
    private BigDecimal price;
}
