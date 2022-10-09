package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    Business getBusiness() {
        BusinessImpl buss = new BusinessImpl();
        buss.setLogo("ABC");
        return buss;
    }
}
