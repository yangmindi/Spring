package com.atguigu1.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LogUtils {

    //想在执行目标方法之前运行
    @Before(value = "execution(public int com.atguigu1.impl.MyMathCalculator.*(int,int))")
    public static void logStart(JoinPoint method){
        System.out.println("【xxx】方法开始执行，用的参数列表【xxx】");
    }
    //想在目标方法正常执行完成之后执行
    @AfterReturning(value = "execution(public int com.atguigu1.impl.MyMathCalculator.*(int,int))",returning = "result")
    public static void logReturn(JoinPoint method, Object result){
        System.out.println("【xxx】方法执行完成，计算结果是:"+result);
    }
    //想在目标方法出现异常的时候执行
    @AfterThrowing(value = "execution(public int com.atguigu1.impl.MyMathCalculator.*(int,int))",throwing = "e")
    public static void logException(JoinPoint method,Exception e){
        System.out.println("【xxx】方法执行出现异常，异常信息是：这个异常已经通知测试小组进行排查");
    }
//    //想在目标方法结束的时候执行
    @After(value = "execution(public int com.atguigu1.impl.MyMathCalculator.*(int,int))")
    public static void logEnd(JoinPoint method){
        System.out.println("【xxx】方法最终结束了");
    }

}
