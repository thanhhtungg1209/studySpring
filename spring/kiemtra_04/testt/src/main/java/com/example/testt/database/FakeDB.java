package com.example.testt.database;

import com.example.testt.model.User;

import java.util.ArrayList;
import java.util.List;

public class FakeDB {
    public static List<User> users = new ArrayList<>(List.of(
            new User(1,"Tung", "tung@gmail.com","1","0366086663","Bac Ninh","1"),
            new User(2,"Hieu", "hieu@gmail.com","2","01234567","Ha Noi","2"),
            new User(3,"Tuan Anh", "tuananh@gmail.com","3","02165487","Hai Duong","3")

            ));

}
