package com.liu.vo.response;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/21 19:27
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ResponseCommentListVo {

    private String userName;
    private String userIdentity;
    private String commentDesc;
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime commentTime;
}
