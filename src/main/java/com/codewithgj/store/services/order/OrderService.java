package com.codewithgj.store.services.order;

import com.codewithgj.store.services.payment.PaymentService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//@Service("order")
public class OrderService {
    private PaymentService paymentService;

    public OrderService() {}

    @Autowired
    public OrderService(@Qualifier("paypal") PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostConstruct
    public void init() {
        System.out.println("Post Construct Called");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("Pre Destroy Called");
    }

    public void placeOrder() {
        this.paymentService.processPayment(10);
    }
}
