package com.springcoe;


public class Car {

    public Engine engine;

//    public Engine getEngine() {
//        return engine;
//    }

//    public void setEngine(Engine engine) {
//        this.engine = engine;
//    }
//
    public Car(Engine engine) {
        this.engine = engine;
    }

    public Car() {
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                '}';
    }
}
