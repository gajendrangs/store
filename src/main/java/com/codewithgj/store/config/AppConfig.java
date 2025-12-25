package com.codewithgj.store.config;

import com.codewithgj.store.services.notification.MailNotificationService;
import com.codewithgj.store.services.notification.NotificationService;
import com.codewithgj.store.services.order.OrderService;
import com.codewithgj.store.services.payment.GpayPaymentService;
import com.codewithgj.store.services.payment.PaymentService;
import com.codewithgj.store.services.payment.PaypalPaymentService;
import com.codewithgj.store.services.user.InMemoryUserRepository;
import com.codewithgj.store.services.user.UserRepository;
import com.codewithgj.store.services.user.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Value("${paymentGateway}")
    private String paymentGateway;

    @Bean
    @Scope("singleton")
    public OrderService orderService() {
        if(paymentGateway.equals("paypal")) {
            return new OrderService(paypal());
        }
        return new OrderService(gpay());
    }

    @Bean
    public PaymentService paypal() {
        return new PaypalPaymentService();
    }

    @Bean
    @Primary
    public PaymentService gpay() {
        return new GpayPaymentService();
    }

    @Bean
    public UserService user() {
        return new UserService(inMemoryRepository(), notification());
    }

    @Bean
    public UserRepository inMemoryRepository() {
        return new InMemoryUserRepository();
    }

    @Bean
    public NotificationService notification() {
        return new MailNotificationService();
    }
}
