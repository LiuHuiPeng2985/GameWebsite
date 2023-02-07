package com.liu.common;

import lombok.Getter;
import lombok.Setter;

/*
 * @author  LiuHuiPeng
 * @date    2022/7/30 17:43
 */

@Getter
@Setter
public class Result<T> {

    /**
     * 状态码2XX,4XX,5XX:200代表成功，404代表找不到，500服务器错误
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 数据
     */
    private T data;

    public Result setMsg(String msg){
        this.msg = msg;
        return this;
    }

    public Result setData(T data){
        this.data = data;
        return this;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, String msg, T date) {
        this.code = code;
        this.msg = msg;
        this.data = date;
    }

    /**
     * 失败方法
     * @return
     */
    public static Result getFailure(){
        return new Result(400,"失败");
    }

    /**
     * 成功方法
     * @return
     */
    public static Result getSuccess(){
        return new Result(200,"成功");
    }
}
