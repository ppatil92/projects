package com.accela.interview.demo.controller;

import com.accela.interview.demo.entity.Person;
import com.accela.interview.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    public Person getAllTutorials(@PathVariable(required = true) String id) {
        return personService.getPersonById(id);
    }
}
