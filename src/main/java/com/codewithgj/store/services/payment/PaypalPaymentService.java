package com.codewithgj.store.services.payment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service("paypal")
public class PaypalPaymentService implements PaymentService {

    @Value("${paypal.apiUrl}")
    private String apiUrl;

    @Value("${paypal.timeout}")
    private int timeout;

    @Value("${paypal.enabled}")
    private boolean enableGateway;

    @Value("${paypal.currencies}")
    private List<String> currencies;

    @Override
    public void processPayment(double amount) {
        System.out.println("Paypal");
        System.out.println("Amount: "+amount);
        System.out.println("API URL: "+ apiUrl);
        System.out.println("Timeout: "+ timeout);
        System.out.println("Gateway Enabled: "+ enableGateway);
        System.out.println("Currencies: "+currencies);
    }
}
