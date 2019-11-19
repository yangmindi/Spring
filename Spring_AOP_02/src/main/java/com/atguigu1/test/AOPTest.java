package com.atguigu1.test;

import com.atguigu1.impl.MyMathCalculator;
import com.atguigu1.inter.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@EnableAspectJAutoProxy
public class AOPTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    @Test
    public void test(){
        MyMathCalculator bean = ioc.getBean(MyMathCalculator.class);
        int add = bean.add(2, 1);
        System.out.println("result:" + add);
//        System.out.println(bean);
        System.out.println(bean.getClass());

        Calculator bean2 = (Calculator) ioc.getBean("myMathCalculator");
        System.out.println(bean2.getClass());
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

    @Test
    public void test02(){
        MyMathCalculator bean = ioc.getBean(MyMathCalculator.class);
        bean.div(1,1);
        System.out.println("======");
        bean.add(1,2);
    }

    @Test
    public void test03(){
        MyMathCalculator bean = ioc.getBean(MyMathCalculator.class);
        int add = bean.div(1, 0);
        System.out.println("======" + add);
    }
}
