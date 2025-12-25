package com.codewithgj.store.services.user;

import com.codewithgj.store.services.notification.NotificationService;

public class UserService {
    UserRepository userRepository;
    NotificationService notificationService;

    public UserService(UserRepository userRepository, NotificationService notificationService) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    public void registerUser(User user) {
        if(userRepository.searchUser(user.getEmail()) != null) {
            throw new IllegalArgumentException("User already exists");
        }
        userRepository.save(user);
        notificationService.send(user.getEmail(), "Registration successful");
    }
}
