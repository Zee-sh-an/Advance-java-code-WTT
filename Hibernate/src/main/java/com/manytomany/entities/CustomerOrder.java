package com.manytomany.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;

//one to many
@Entity
public class CustomerOrder {//Order is an identifier

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private double price;

    @ManyToMany
    private List<Customer> customers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", customers=" + customers +
                '}';
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public CustomerOrder(int id, String name, double price, List<Customer> customers) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.customers = customers;
    }

    public CustomerOrder() {
    }
}
