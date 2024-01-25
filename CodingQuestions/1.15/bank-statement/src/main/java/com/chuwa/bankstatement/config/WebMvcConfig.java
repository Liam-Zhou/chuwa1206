package com.chuwa.bankstatement.config;

import com.chuwa.bankstatement.interceptor.RequestProcessingTimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final RequestProcessingTimeInterceptor requestProcessingTimeInterceptor;

    @Autowired
    public WebMvcConfig(RequestProcessingTimeInterceptor requestProcessingTimeInterceptor) {
        this.requestProcessingTimeInterceptor = requestProcessingTimeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestProcessingTimeInterceptor);
    }
}