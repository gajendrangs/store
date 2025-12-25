package com.codewithgj.store.services.notification;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("mail")
@Primary
public class MailNotificationService implements NotificationService{

    @Value("${notification.mailServer}")
    private String mailServer;

    @Value("${notification.port}")
    private int port;

    @Override
    public void send(String email, String message) {
        System.out.println("Mail");
        System.out.println("Message: "+message+" sent to "+email);
        System.out.println("Mail Server: "+mailServer);
        System.out.println("Port: "+port);
    }
}
