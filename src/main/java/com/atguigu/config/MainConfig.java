package com.atguigu.config;

import com.atguigu.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {

    @Bean(value = "person")
    public Person person01(){
        return new Person("lisi",20);
    }
}
