package com.atguigu.config;

import com.atguigu.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * bean的生命周期：
 *      bean的创建--初始化--销毁的过程
 * 容器管理bean的生命周期：
 * 我们可以定义初始化和销毁方法；容器在bean进行到声明周期的时候来调用我们自定义的初始化和销毁方法
 *
 * 构造（对象创建）
 *      单实例：在容器启动的时候创建对象
 *      多实例：在每次获取的时候创建对象
 *初始化：
 *      对象创建完成，并赋值好，调用初始化方法。。。
 * 销毁：
 *      单实例：关闭容器的时候
 *      多实例：容器不会管理这个Bean；容器不后悔调用销毁方法
 *
 * 1）指定初始化和销毁方法：
 *      通过@Bean指定init-method和destory-method
 */
@ComponentScan("com.atguigu.bean")
@Configuration
public class MainConfigOfLifeCycle {

//    @Scope("prototype")
    @Bean(initMethod = "init",destroyMethod = "destory")
    public Car car(){
        return new Car();
    }
}
