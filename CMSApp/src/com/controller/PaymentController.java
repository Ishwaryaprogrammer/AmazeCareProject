package com.controller;

import com.enums.PaymentType;
import com.model.Payment;
import com.util.PaymentFactory;

import java.util.Scanner;package com.controller;

import com.enums.PaymentType;
import com.model.Payment;
import com.util.PaymentFactory;

import java.util.Scanner;

public class PaymentController {
    public static void main(String[] args) {
        PaymentFactory paymentFactory=new PaymentFactory();

        String res=paymentFactory.getInstance(PaymentType.DEBIT);
        System.out.println(res);


    }
}


public class PaymentController {
    public static void main(String[] args) {
        PaymentFactory paymentFactory=new PaymentFactory();

        String res=paymentFactory.getInstance(PaymentType.DEBIT);
        System.out.println(res);


    }
}
