package com.atguigu.config;

import com.atguigu.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class MainConfig2 {

    /**
     * prototype:多实例的
     * sinleton:单实例的
     * request:同一次请求创建一个单实例
     * session:同一个session创建一个实例
     * @return
     */
    //默认单实例
//    @Scope("prototype")
    @Lazy
    @Bean("person")
    public Person person(){
        System.out.println("给容器中添加Person....");
        return new Person("张三",25);
    }


}
