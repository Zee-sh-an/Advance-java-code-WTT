package com.springcoe;

import org.springframework.context.annotation.Bean;


public class Engine {

    public String company;
    public String model;
    public String status;

//    public String getCompany() {
//        return company;
//    }
//
//    public void setCompany(String company) {
//        this.company = company;
//    }
//
//    public String getModel() {
//        return model;
//    }
//
//    public void setModel(String model) {
//        this.model = model;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }

    public Engine(String company, String model, String status) {
        this.company = company;
        this.model = model;
        this.status = status;
    }

    public Engine() {
        super();
    }

    @Override
    public String toString() {
        return "Engine{" +
                "company='" + company + '\'' +
                ", model='" + model + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
