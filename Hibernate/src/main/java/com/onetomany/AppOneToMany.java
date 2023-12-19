package com.onetomany;

import com.onetomany.entities.CustomerOrder;
import com.onetomany.entities.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class AppOneToMany {

    public static void main(String[] args) {
//       you have to set the id one to many and many to one
//       change the id to run otherwise it will throw error
//    ==>NOTE uncomment the data from hibernate.cfg.xml

        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        System.out.println(sessionFactory);

        Customer customer=new Customer();
        customer.setId(6);
        customer.setName("Zeeshan");
        customer.setEmail("zeeshan3167@gmail.com");

        CustomerOrder order1=new CustomerOrder();
        order1.setId(456);
        order1.setName("Box");
        order1.setPrice(60);
        order1.setCustomer(customer);


        CustomerOrder order2=new CustomerOrder();
        order2.setId(556);
        order2.setName("Bo");
        order2.setPrice(60);
        order2.setCustomer(customer);

        List<CustomerOrder> orderList=new ArrayList<CustomerOrder>();
        orderList.add(order1);
        orderList.add(order2);

        customer.setOrders(orderList);

        Session session=sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
//        try {

            session.save(customer);
            transaction.commit();

//        }catch (HibernateException e){

//            transaction.rollback();
//        }
        session.close();
        sessionFactory.close();
    }

}
