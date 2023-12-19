package com.manytomany;


import com.manytomany.entities.Customer;
import com.manytomany.entities.CustomerOrder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class AppManyToMany {
//    many to many
    public static void main(String[] args) {

        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

        Customer customer1=new Customer();
        customer1.setId(1);
        customer1.setName("Ayush");
        customer1.setEmail("Ayush@gmail.com");

        Customer customer2=new Customer();
        customer2.setId(2);
        customer2.setName("Ravina");
        customer2.setEmail("Ravina@gmail.com");

        CustomerOrder order1 =new CustomerOrder();
        order1.setId(11);
        order1.setName("Pen");
        order1.setPrice(455);

        CustomerOrder order2 =new CustomerOrder();
        order2.setId(111);
        order2.setName("Clock");
        order2.setPrice(3000);

        List<Customer> customerList=new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);

        order1.setCustomers(customerList);

        List<CustomerOrder> orderList=new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);

        customer1.setOrders(orderList);

        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        session.save(customer1);
        session.save(customer2);
        session.save(order1);
        session.save(order2);
        transaction.commit();

        session.close();
        sessionFactory.close();
    }

}
