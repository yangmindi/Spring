package com.atguigu.proxy;

import com.atguigu.inter.Calculator;
import com.atguigu.utils.LogUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 帮Calculator.Java生成代理对象
 * Object newProxyInstance()
 */
public class CalculatorProxy {
    /**
     * 为传入的对象创建一个代理对象
     *
     * @param calculator ：被代理对象（王宝强）
     * @return 代理对象（宋喆）
     */
    public static Calculator getProxy(final Calculator calculator) {
        //方法执行器。帮我们目标对象执行目标方法
//        InvocationHandler h = new InvocationHandler() {
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//
//                //利用反射执行目标方法
//                //目标方法执行后的返回值
//                System.out.println("这是动态代理将要帮你执行方法...");
//                Object result = method.invoke(calculator, args);
//
//                //返回值必须返回出去外界才能拿到真正执行后的返回值
//                return result;
//            }
//        };
        //目标方法执行器，帮我们目标对象执行目标方法
        InvocationHandler h = new InvocationHandler() {
            /**
             *
             * @param proxy ：代理对象，不要使用，给jdk使用，任何时候都不要动这个对象
             * @param method ： 当前将要执行的目标对象的方法
             * @param args ： 方法调用时外界传入的参数值
             * @return
             * @throws Throwable
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println("这个是动态代理将要帮你执行的方法");
                Object result = null;
                try {
                    LogUtils.logStart(method,args);
                    //利用反射执行目标方法
                    /**
                     * 1：哪个对象的这个方法
                     * 2：传入的参数
                     */
                    result = method.invoke(calculator, args);
                    LogUtils.logReturn(method,result);
                } catch (Exception e) {
                    LogUtils.logException(method,e);
                }finally {
                    LogUtils.logEnd(method);
                }
                //目标方法执行后的返回值，外界拿到值
                return result;
            }
        };
        Class<?>[] interfaces = calculator.getClass().getInterfaces();
        ClassLoader loader = calculator.getClass().getClassLoader();
        //Proxy为目标对象创建代理对象
        Object proxy = Proxy.newProxyInstance(loader, interfaces, h);
        return (Calculator) proxy;
    }
}
