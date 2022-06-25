package com.helloworld.helloworld.service;

import com.helloworld.helloworld.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getByUsername(String username);
}
