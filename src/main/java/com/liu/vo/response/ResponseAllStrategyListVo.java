package com.liu.vo.response;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/27 11:05
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ResponseAllStrategyListVo {

    private Integer id;
    private String userName;
    private Integer userIdentity;
    private String title;
    private String content;
    private String game;
    private Integer pass;
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime strategyCreateTime;
}
