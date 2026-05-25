package com.model;

public class Neft implements Payment{

    @Override
    public String processPayment() {
        return "Neft payment processed";
    }
}
