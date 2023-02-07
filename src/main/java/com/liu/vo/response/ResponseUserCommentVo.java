package com.liu.vo.response;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/24 19:10
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ResponseUserCommentVo {

    private Integer id;
    private String gameName;
    private String commentDesc;
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime commentTime;
}
