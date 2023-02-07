package com.liu.vo.response;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/14 12:13
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ResponseGameUpdateVo {

    private Integer id;
    private String name;
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}
