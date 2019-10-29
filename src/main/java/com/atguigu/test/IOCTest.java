package com.atguigu.test;

import com.atguigu.bean.Blue;
import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;
import com.atguigu.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

public class IOCTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
    @Test
    public void test01(){
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String definitionName : definitionNames) {
            System.out.println(definitionName);
        }
    }

    @Test
    public void test02(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
//        String[] definitionNames = applicationContext.getBeanDefinitionNames();
//        for (String definitionName : definitionNames) {
//            System.out.println(definitionName);
//        }
//
        System.out.println("ioc容器创建完成...");
        Object person = applicationContext.getBean("person");
        Object person1 = applicationContext.getBean("person");
        System.out.println(person == person1);
//        Object person = applicationContext.getBean("person");
//        Object person1 = applicationContext.getBean("person");
//        System.out.println(person == person1);
    }

    @Test
    public void test03(){
        String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);
        for (String s : namesForType) {
            System.out.println(s);
        }
        Map<String, Person> beansOfType = applicationContext.getBeansOfType(Person.class);
        System.out.println(beansOfType);
    }

    @Test
    public void testImport(){
        printBeans(applicationContext);
        Blue bean = applicationContext.getBean(Blue.class);
        System.out.println(bean);
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext) {
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String definitionName : definitionNames) {
            System.out.println(definitionName);
        }
    }
}
