package com.codewithgj.store.services.user;

public class User {
    private long userId;
    private String email;
    private String password;
    private String name;

    public User(long id, String email, String password, String name) {
        this.userId = id;
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
