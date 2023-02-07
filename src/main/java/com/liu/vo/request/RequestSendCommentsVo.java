package com.liu.vo.request;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/21 21:06
 */

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestSendCommentsVo {

    private Integer userId;
    private Integer gameId;
    private String commentDesc;
}
