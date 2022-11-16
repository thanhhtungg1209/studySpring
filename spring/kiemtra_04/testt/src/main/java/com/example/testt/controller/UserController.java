package com.example.testt.controller;

import com.example.testt.model.UserDto;
import com.example.testt.model.PageUser;
import com.example.testt.model.User;
import com.example.testt.request.UpsertPasswordRequest;
import com.example.testt.request.UpsertUserRequest;
import com.example.testt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserService userService;

    // Get all
    @GetMapping("users/all")
    public List<User> getAll() {
        return userService.findAll();
    }

    // 1.   GET http://localhost:8080/api/v1/users (mặc định page = 1, limit = 10)
    @GetMapping("users")
    public PageUser getPageUser(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
        return userService.getPageUser(page, limit);
    }

    //2.  GET http://localhost:8080/api/v1/search?name={nameValue}
    @GetMapping("users/search")
    public List<UserDto> getUserByName(@RequestParam String name) {
        return userService.getUserByName(name);
    }

    //3.   GET http://localhost:8080/api/v1/users/{id}
    @GetMapping("users/{id}")
    public UserDto findUserById(@PathVariable int id) {
        return userService.findUserById(id);
    }

    //4.  POST http://localhost:8080/api/v1/users
    @PostMapping("users")
    public UserDto createUser(@RequestBody UpsertUserRequest request) {
        return userService.createUser(request);
    }

    //5.  PUT http://localhost:8080/api/v1/users/{id}
    @PutMapping("users/{id}")
    public UserDto updateUser(@RequestBody UpsertUserRequest request, @PathVariable int id) {
        return userService.updateUser(request, id);
    }

    //6.  http://localhost:8080/api/v1/users/{id}
    @DeleteMapping("users/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    //7.  PUT http://localhost:8080/api/v1/users/{id}/update-avatar
    @PutMapping("users/{id}/update-avatar")
    public void updateAvatar(@RequestBody UpsertUserRequest request, @PathVariable int id) {
        userService.updateAvatar(request, id);
    }

    //8.  http://localhost:8080/api/v1/users/{id}/update-password
    @PutMapping("users/{id}/update-password")
    public void updatePassword(@RequestBody UpsertPasswordRequest request, @PathVariable int id) {
        userService.updatePassword(request, id);
    }

    //9.  http://localhost:8080/api/v1/users/{id}/forgot-password
    @PostMapping("users/{id}/forgot-password")
    public String forgotPassword(@PathVariable int id) {
        return userService.forgotPassword(id);
    }

}



