package com.springcoe.question_3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages ="com.springcoe.question_3")
public class Config {

    @Bean
    public Product getProduct(){
//        return new Product(55,"Door");
        return new Product();
    }
}
