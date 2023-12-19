package com.Question5.config;

import com.Question5.entities.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.Question5")
@EnableTransactionManagement
public class StudentConfiguration {

    @Bean
    public DriverManagerDataSource getDataSource(){

        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:4040/product");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean getSessionfactory(){
        LocalSessionFactoryBean factoryBean=new LocalSessionFactoryBean();
        factoryBean.setDataSource(getDataSource());
        Properties properties=new Properties();
        properties.put("hibernate.show_sql","true");
        properties.put("hibernate.hbm2ddl.auto","update");
        factoryBean.setHibernateProperties(properties);
        factoryBean.setAnnotatedClasses(Student.class);
//        factoryBean.setAnnotatedPackages("com.Question5.entities.Student");
        return factoryBean;
    }

//    @Bean
//    public HibernateTemplate hibernateTemplate(){
//
//        HibernateTemplate hibernateTemplate=new HibernateTemplate();
//        hibernateTemplate.setSessionFactory(getSessionfactory().getObject());
//
//        return hibernateTemplate;
//    }

    @Bean
    public HibernateTransactionManager getTransactionManager(){

        HibernateTransactionManager transactionManager =new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionfactory().getObject());

        return transactionManager;
    }

}
