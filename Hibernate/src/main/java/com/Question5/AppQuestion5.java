package com.Question5;

import com.Question5.config.StudentConfiguration;
import com.Question5.entities.Student;
import com.Question5.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppQuestion5 {

    public static void main(String[] args) {

        ApplicationContext context=new AnnotationConfigApplicationContext(StudentConfiguration.class);
        StudentService studentService=context.getBean("studentService",StudentService.class);
        studentService.saveStudent();

    }
}
