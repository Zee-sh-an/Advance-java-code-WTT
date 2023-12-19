package com.Question5.repo;

import com.Question5.entities.Student;
import jakarta.transaction.RollbackException;
import jakarta.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

import java.io.Serializable;

@Repository
public class StudentRepo {

//    @Autowired
//    private HibernateTemplate hibernateTemplate;
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void add(Student student5) {
//        this.hibernateTemplate.getc.save(student5);
        this.sessionFactory.getCurrentSession().save(student5);
//        this.hibernateTemplate.save(student5);
    }

}
