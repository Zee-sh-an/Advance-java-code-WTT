package com.hibernate;

import com.hibernate.entities.Customer;
import com.hibernate.entities.CustomerOrder;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class App {
    public static void main( String[] args )
    {
        try {

            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

            Customer customer = new Customer();
//        customer.setId(45);
            customer.setName("Zeeshan");
            customer.setEmail("zk9897215904@gmail.com");

            CustomerOrder order = new CustomerOrder();
//        order.setId(1);//you can not give this id if u use generatedValue in in this entity
            order.setName("Lunch");
            order.setPrice(56.7);

            customer.setOrder(order);
            order.setCustomer(customer);

            Session session = sessionFactory.openSession();
//            Transaction transaction = session.beginTransaction();

//            CriteriaBuilder builder = session.getCriteriaBuilder();
//            CriteriaQuery<Customer> criteriaQuery = builder.createQuery(Customer.class);
//            Root root = criteriaQuery.from(Customer.class);
//
//
//            criteriaQuery.select(root);
//            criteriaQuery.where(builder.like(root.get("order").get("name"), "Mouse"));
//            criteriaQuery.where(builder.equal(root.get("id"), 2));
//            Query<Customer> customerQuery = session.createQuery(criteriaQuery);
//            List customerList = customerQuery.getResultList();
//            for (Object c1 : customerList) {
//                System.out.println(c1);
//            }

            System.out.println("___________________________________________________________________________");


//            session.save(customer);
//            transaction.commit();
//        comment the toString customerOrder field otherwise it will create a endless loop for calling all customers in db

//        String query1="select c from Customer c where c.email =:email";
            String query1 ="from Customer";
        Query q1=session.createQuery(query1);
//        q1.setParameter("email","zeeshan3167@gmail.com");
        List list1=q1.list();
        for (Object c: list1) {
            System.out.println(c);
        }

            System.out.println("___________________________________________________________________________");
//
//        String query="select * from Customer";
//        NativeQuery nativeQuery = session.createNativeQuery(query);
//        List<Object []> list =nativeQuery.list();
//        for (Object [] q: list) {
//            System.out.println(Arrays.deepToString(q));
//        }

            session.close();
            sessionFactory.close();

//            throw new RuntimeException();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
