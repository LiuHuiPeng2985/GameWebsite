package com.liu.vo.response;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/24 14:21
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ResponseUserGameLikesVo {

    private Integer id;
    private Integer gameId;
    private String img;
    private String type;
    private String name;
    private BigDecimal price;
    private Integer likes;
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime likesTime;
}
