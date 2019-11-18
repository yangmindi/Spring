package com.atguigu1.test;

import com.atguigu1.impl.MyMathCalculator;
import com.atguigu1.inter.Calculator;
import com.atguigu1.proxy.CalculatorProxy;
import org.junit.Test;

import java.util.Arrays;

public class AOPTest {

    @Test
    public void test(){
        Calculator calculator = new MyMathCalculator();
        //calculator.add(1,2);

        System.out.println("[===========]");

        //如果是拿到了这个对象的代理对象；代理对象执行加减乘除
        Calculator proxy = CalculatorProxy.getProxy(calculator);

        System.out.println(Arrays.asList(proxy.getClass().getInterfaces()));
        proxy.add(3,5);
        proxy.div(1,2);
    }
}
