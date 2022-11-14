package com.example.firstapp1.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class UpsertBookRequest {
    private String name;
    private String description;
    private int publishYear;
}
