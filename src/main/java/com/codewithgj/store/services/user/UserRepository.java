package com.codewithgj.store.services.user;

public interface UserRepository {
    void save(User user);
    User searchUser(String email);
}
