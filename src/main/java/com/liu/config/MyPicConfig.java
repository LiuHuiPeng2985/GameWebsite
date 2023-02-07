package com.liu.config;

/*
 * @author  LiuHuiPeng
 * @date    2022/7/3 10:35
 * 图片的静态资源映射
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyPicConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/img/**").addResourceLocations("file:D:\\网站制作\\gameWebsite\\src\\main\\resources\\static\\img");
    }
}
