package com.atguigu.config;

import com.atguigu.bean.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScans(
        value = {
                @ComponentScan(value = "com.atguigu",includeFilters = {
                        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class)
                },useDefaultFilters = false)
        }
)
public class MainConfig {

    @Bean(value = "person")
    public Person person01(){
        return new Person("lisi",20);
    }
}
