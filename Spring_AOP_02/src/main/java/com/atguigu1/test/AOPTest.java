package com.atguigu1.test;

import com.atguigu1.inter.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@EnableAspectJAutoProxy
public class AOPTest {

    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Calculator bean = ioc.getBean(Calculator.class);
        int add = bean.add(2, 1);
        System.out.println("result:" + add);

//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
//
//        System.out.println(arithmeticCalculator.getClass().getName());
//
//        int result = arithmeticCalculator.add(1, 2);
//        System.out.println("result:" + result);
//
//        result = arithmeticCalculator.div(1000, 10);
//        System.out.println("result:" + result);
    }
}
