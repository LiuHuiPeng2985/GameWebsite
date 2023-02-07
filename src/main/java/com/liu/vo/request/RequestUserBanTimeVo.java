package com.liu.vo.request;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/27 16:25
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class RequestUserBanTimeVo {

    private Integer id;
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss'")
    private String banTime;
}
