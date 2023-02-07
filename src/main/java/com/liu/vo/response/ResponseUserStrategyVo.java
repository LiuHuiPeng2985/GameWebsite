package com.liu.vo.response;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/24 16:28
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ResponseUserStrategyVo {

    private Integer id;
    private String title;
    private String content;
    private String game;
    private Integer pass;
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime strategyCreateTime;
}
