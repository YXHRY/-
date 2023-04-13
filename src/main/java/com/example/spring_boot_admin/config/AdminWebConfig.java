package com.example.spring_boot_admin.config;

import com.example.spring_boot_admin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 1.编写一个拦截器实现HandlerInterceptor接口
 * 2.拦截器注册到容器中（实现WebMvcConfigurer的addInterceptors
 * 3.指定拦截规则【入宫拦截所有，静态资源也会被拦截】
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer{
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/*")//不会拦截静态文件
//                .addPathPatterns("/**")//所有请求都被拦截，包括静态请求
//                .excludePathPatterns("/","/login","/css/**","/images/**");
                .excludePathPatterns("/","/login","/student","/user");

    }
}
