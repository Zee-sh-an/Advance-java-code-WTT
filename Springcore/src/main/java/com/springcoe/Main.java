package com.springcoe;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context=new ClassPathXmlApplicationContext("testng.xml");
        Car car=(Car) context.getBean("car1");
        System.out.println(car);
        System.out.println(car.engine);

    }
}