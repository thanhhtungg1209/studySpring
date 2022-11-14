package com.example.homework.repository;

import com.example.homework.database.FakeDB;
import com.example.homework.model.User;
import com.example.homework.request.UserRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    public List<User> findAll(){
        return FakeDB.users;
    }
    public Optional<User> findByRequest(UserRequest request){
        return FakeDB.users
                .stream()
                .filter(user -> (user.getUsername().equals(request.getUsername())
                        && user.getPassword().equals(request.getPassword())))
                .findFirst();
    }
}
