package com.chuwa.bankstatement.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
