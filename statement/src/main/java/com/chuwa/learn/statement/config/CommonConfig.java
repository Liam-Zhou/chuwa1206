package com.chuwa.learn.statement.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
