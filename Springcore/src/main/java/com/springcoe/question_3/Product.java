package com.springcoe.question_3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class Product {

    @Value("55")
    private int ProductId;
    @Value("Box")
    private String ProductName;

//    public int getProductId() {
//        return ProductId;
//    }
//
//    public void setProductId(int productId) {
//        ProductId = productId;
//    }
//
//    public String getProductName() {
//        return ProductName;
//    }
//
//    public void setProductName(String productName) {
//        ProductName = productName;
//    }
//
        public Product(int productId, String productName) {
        ProductId = productId;
        ProductName = productName;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "ProductId=" + ProductId +
                ", ProductName='" + ProductName + '\'' +
                '}';

    }
}
