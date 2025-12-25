package com.codewithgj.store.services.payment;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//@Service("gpay")
//@Primary
public class GpayPaymentService implements PaymentService{

    @Override
    public void processPayment(double amount) {
        System.out.println("GPay");
        System.out.println("Amount: "+amount);
    }
}
