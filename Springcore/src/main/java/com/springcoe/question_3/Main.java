package com.springcoe.question_3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

    public static void main(String[] args) {

        ApplicationContext context= new AnnotationConfigApplicationContext(Config.class);
//for taking bean it will take camel case of the class like Product class as product
        Product product=(Product) context.getBean("getProduct", Product.class);
        System.out.println(product);

    }

}
