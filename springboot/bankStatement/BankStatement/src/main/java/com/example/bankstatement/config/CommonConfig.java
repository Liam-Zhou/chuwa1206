package com.example.bankstatement.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Alex D.
 */
@Configuration
public class CommonConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
