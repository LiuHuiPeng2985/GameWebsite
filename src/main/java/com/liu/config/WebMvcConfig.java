package com.liu.config;

/*
 * @author  LiuHuiPeng
 * @date    2022/7/30 18:00
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    //视图路径映射，跳转到login页面
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/gameWebsite/").setViewName("forward:login.html");
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/page/**");
//    }
}
