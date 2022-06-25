package com.helloworld.helloworld.controller;

import com.helloworld.helloworld.model.User;
import com.helloworld.helloworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/api/users")
    @ResponseBody
    public List<User> getUsers(){
        return userService.getAllUsers();
    }
}
