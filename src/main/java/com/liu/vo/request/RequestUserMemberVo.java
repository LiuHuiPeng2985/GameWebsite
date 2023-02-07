package com.liu.vo.request;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/25 17:34
 */

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RequestUserMemberVo {

    private Integer newsType;
    private Integer userId;
    private LocalDateTime sendTime;
}
