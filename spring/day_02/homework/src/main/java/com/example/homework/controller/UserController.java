package com.example.homework.controller;

import com.example.homework.request.UserRequest;
import com.example.homework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;



    @PostMapping("login")
    public String getUser(@RequestBody UserRequest request){
        return userService.getUser(request);
    }

}
