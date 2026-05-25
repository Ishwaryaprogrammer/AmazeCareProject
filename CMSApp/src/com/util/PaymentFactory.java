package com.util;

import com.enums.PaymentType;
import com.model.Debit;
import com.model.Neft;
import com.model.Upi;

public class PaymentFactory {
    public String getInstance(PaymentType paymentType) {
        if(paymentType.equals(null)){
            throw new RuntimeException("no payment processed");
        }
        if (paymentType.toString().equals("NEFT")) {
            return new Neft().processPayment();
        }else if(paymentType.toString().equals("DEBIT")){
            return new Debit().processPayment();
        }else{
            return new Upi().processPayment();
        }


    }
}
