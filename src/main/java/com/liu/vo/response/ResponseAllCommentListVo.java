package com.liu.vo.response;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/27 14:28
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ResponseAllCommentListVo {

    private Integer id;
    private Integer userId;
    private String userName;
    private Integer userIdentity;
    private String gameName;
    private String commentDesc;
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime commentTime;
}
