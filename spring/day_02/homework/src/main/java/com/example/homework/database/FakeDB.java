package com.example.homework.database;

import com.example.homework.model.User;

import java.util.ArrayList;
import java.util.List;

public class FakeDB {
    public static List<User> users = new ArrayList<>(List.of(
            new User(1,"A","A@gmail.com","1","1"),
            new User(2,"B","B@gmail.com","2","2"),
            new User(3,"C","C@gmail.com","3","3")
    ));
}
