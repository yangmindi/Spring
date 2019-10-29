package com.atguigu.config;

import com.atguigu.bean.Person;
import com.atguigu.condition.LinuxCondition;
import com.atguigu.condition.WindowsCondition;
import org.springframework.context.annotation.*;

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

    @Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person person01(){
        return new Person("Bill Gates",62);
    }

    @Conditional(LinuxCondition.class)
    @Bean("linus")
    public Person person02(){
        return new Person("linus",48);
    }
}
