package com.liu.vo.response;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/16 14:13
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ResponseStrategyListVo {

    private Integer id;
    private String userName;
    private Integer userIdentity;
    private String title;
    private String content;
    private String game;
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime strategyCreateTime;
}
