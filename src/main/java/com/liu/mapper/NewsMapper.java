package com.liu.mapper;

/*
 * @author  LiuHuiPeng
 * @date    2022/8/24 21:40
 */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liu.entity.News;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NewsMapper extends BaseMapper<News> {

    //用户消息
    @Select("select * from news where news.user_id = #{id} order by send_time desc")
    @Results(id = "newsMap",value = {
            @Result(id = true,column = "news_id",property = "id"),
            @Result(column = "news_type",property = "newsType"),
            @Result(column = "user_name",property = "userName"),
            @Result(column = "game_name",property = "gameName"),
            @Result(column = "recharge",property = "recharge"),
            @Result(column = "send_time",property = "sendTime")
    })
    List<News> getUserNews(Integer id);
}
