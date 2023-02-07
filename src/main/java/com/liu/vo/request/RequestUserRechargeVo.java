package com.liu.vo.request;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/25 14:27
 */

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class RequestUserRechargeVo {

    private Integer newsType;
    private Integer userId;
    private BigDecimal recharge;
    private LocalDateTime sendTime;
}
