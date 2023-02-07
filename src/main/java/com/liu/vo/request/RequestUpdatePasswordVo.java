package com.liu.vo.request;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/23 16:42
 */

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestUpdatePasswordVo {

    private Integer userId;
    private String oldPassword;
    private String password;
}
