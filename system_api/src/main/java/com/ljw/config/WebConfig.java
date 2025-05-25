package com.ljw.config;

import com.ljw.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loginInterceptor)
//                .addPathPatterns("/**") // 拦截所有路径
//                .excludePathPatterns( // 排除以下路径
//                        "/login",          // 登录页面
//                        "/auth/login",          // 登录页面
//                        "/test/**",
//                        "/static/**",      // 静态资源
//                        "/getCode",
//                        "/doctor/getDoctorById",
//                        "/error"           // 错误页面
//                );
    }
}