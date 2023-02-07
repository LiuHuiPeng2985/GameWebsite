package com.liu.vo.response;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/23 22:12
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ResponseUserGameStorehouseVo{

    private Integer id;
    private Integer gameId;
    private String img;
    private String type;
    private String name;
    private BigDecimal price;
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime buyTime;

}
