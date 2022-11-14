package com.example.homework.service;

import com.example.homework.exception.NotFoundException;
import com.example.homework.model.User;
import com.example.homework.repository.UserRepository;
import com.example.homework.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public String getUser(UserRequest request) {
        if (userRepository.findByRequest(request).isEmpty()) throw new NotFoundException("username hoặc password sai");
        User user = userRepository.findByRequest(request).get();
        return "username: " + user.getUsername()
                + "\n email: " + user.getEmail()
                + "\n avatar: " + user.getAvatar();
    }
}