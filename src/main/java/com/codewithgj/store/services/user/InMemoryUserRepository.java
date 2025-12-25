package com.codewithgj.store.services.user;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserRepository implements UserRepository {

    private Map<String, User> userMap = new HashMap<>();

    @Override
    public void save(User user) {
        userMap.put(user.getEmail(), user);
        System.out.println("Registration Successful!");
    }

    @Override
    public User searchUser(String email) {
        return userMap.getOrDefault(email, null);
    }
}
