package com.gxa.agriculture.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 解决跨域
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                //运行cookie
                .allowCredentials(true)
                //允许访问服务器的源
                .allowedOrigins("*")
                //允许什么样的请求头
                .allowedHeaders("*")
                //允许什么样的请求方式
                .allowedMethods("*");
    }
}
