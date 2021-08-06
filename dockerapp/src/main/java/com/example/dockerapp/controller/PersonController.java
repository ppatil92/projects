package com.example.dockerapp.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/getName")
    public String getName() {
        return "My Name";
    }

}