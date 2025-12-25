package com.codewithgj.store.services.notification;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NotificationManager {

    private final NotificationService notificationService;

    public NotificationManager(@Qualifier("mail") NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void sendNotification() {
        notificationService.send("gj@gmail.com","Welcome");
    }
}
