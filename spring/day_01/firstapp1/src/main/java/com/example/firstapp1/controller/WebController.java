package com.example.firstapp1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    // path : Get/api/helloworld => hello world
   @GetMapping("/api/helloworld")
    public String getHello(){

       return "helloworld";
    }


}
