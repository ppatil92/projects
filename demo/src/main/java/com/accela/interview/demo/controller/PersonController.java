package com.accela.interview.demo.controller;

import com.accela.interview.demo.entity.Person;
import com.accela.interview.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Person> getAllTutorials(@PathVariable(required = true) String id) {
        return personService.getPersonById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Person> createTutorial(@RequestBody Person person) {
       return personService.addPerson(person);
    }
}
