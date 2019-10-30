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
 * 2）通过让Bean实现InitializingBean（定义初始化逻辑）
 *                DisposableBean（定义销毁逻辑）
 * 3）可以使用JSR250
 *      @PostConstruct：在bean创建完成并且属性复制完成；来执行初始化方法
 *      @PreDestory：在容器销毁bean之前通知我们进行清理工作
 * 4）BeanPostProcessor[interface]:bean的后置处理器：
 *      在bean初始化前后进行一些处理工作；
 *      postProcessBeforeInitialization:在初始化之前工作
 *      postProcessAfterInitialization：在初始化之后工作
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
