package com.atguigu1.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Component
public class LogUtils {

    @Pointcut("execution(public int com.atguigu1.impl.MyMathCalculator.*(..))")
    public void hahaMyPoint() {
    }


    //想在执行目标方法之前运行
    @Before(value = "execution(public int com.atguigu1..MyMath*.*(..)) && execution(* *.*(int,*))")
    public static void logStart(JoinPoint joinPoint){
        //获取到目标方法运行时使用的参数
        Object[] args = joinPoint.getArgs();
        //获取到方法名
        String name = joinPoint.getSignature().getName();

        System.out.println("【"+name+"】方法开始执行，用的参数列表【"+ Arrays.asList(args) +"】");
    }
    //想在目标方法正常执行完成之后执行
    @AfterReturning(value = "hahaMyPoint()",returning = "result")
    public static void logReturn(JoinPoint joinPoint,Object result){
        String name = joinPoint.getSignature().getName();
        System.out.println("【"+name+"】方法执行完成，计算结果是:"+result);
    }

    //想在目标方法出现异常的时候执行
    @AfterThrowing(value = "execution(public int com.atguigu1.impl.MyMathCalculator.*(..))",throwing = "exception")
    public static void logException(JoinPoint joinPoint,Exception exception){
        System.out.println("【"+joinPoint.getSignature().getName()+"】方法执行出现异常，异常信息是："+exception+"这个异常已经通知测试小组进行排查");
    }
//    //想在目标方法结束的时候执行
    @After(value = "execution(public int com.atguigu1.impl.MyMathCalculator.*(..))")
    public static void logEnd(JoinPoint joinPoint){
        System.out.println("【"+joinPoint.getSignature().getName()+"】方法最终结束了");
    }

    @Around("hahaMyPoint()")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {

        Object[] args = pjp.getArgs();
        String name = pjp.getSignature().getName();

        Object proceed = null;
        try {
            //就是利用反射调用目标方法即可，就是method.invoke(obj,args);
            System.out.println("【环绕前置通知】【" + name + "方法开始】");
            proceed = pjp.proceed(args);
            System.out.println("【环绕返回通知】【" + name + "方法返回，返回值" + proceed + "】");
        } catch (Throwable throwable) {
            System.out.println("【环绕异常通知】【" + name + "方法出现异常，异常信息：】" + throwable);
            throw throwable;
        } finally {
            System.out.println("【环绕后置通知】【"+name+"方法结果】");
        }

        //反射调用后的返回值也一定要返回出去
        return proceed;
    }
}
