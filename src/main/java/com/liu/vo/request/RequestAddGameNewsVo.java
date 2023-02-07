package com.liu.vo.request;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/24 21:53
 */

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RequestAddGameNewsVo {

    private Integer newsType;
    private Integer userId;
    private Integer gameId;
    private LocalDateTime sendTime;
}
