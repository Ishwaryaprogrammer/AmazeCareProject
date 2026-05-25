package com.model;

public class Debit implements Payment{

    @Override
    public String processPayment() {
        return "Debit payment processed";
    }
}
