package com.codewithgj.store.services.notification;

import org.springframework.stereotype.Service;

@Service("sms")
public class SMSNotificationService implements NotificationService {
    @Override
    public void send(String mobileNumber, String message) {
        System.out.println("SMS");
        System.out.println("Message: "+message+" sent to "+mobileNumber);
    }
}
