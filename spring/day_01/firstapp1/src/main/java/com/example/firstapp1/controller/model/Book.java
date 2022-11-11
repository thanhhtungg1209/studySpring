package com.example.firstapp1.controller.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Book {
    private  int id;
    private String name;
    private String description;
    private int publishYear;
}
