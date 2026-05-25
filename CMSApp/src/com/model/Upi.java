package com.model;

public class Upi implements Payment{

    @Override
    public String processPayment() {
        return "Upi payment processed";
    }
}
