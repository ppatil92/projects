package com.accela.interview.demo.controller;

import com.accela.interview.demo.entity.Person;
import com.accela.interview.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable(required = true) String id) {
        return personService.getPersonById(id);
    }

    @GetMapping("/getAllPerson")
    public @ResponseBody List<Person> getAllPersons() {
        return personService.getAllPerson();
    }

    @PostMapping("/add")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
       return personService.addPerson(person);
    }

    @PostMapping("/edit")
    public ResponseEntity<Person> edit(@RequestBody Person person) {
        return personService.editPerson(person);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable String id) throws Exception {
        personService.deletePersonById(id);
    }

    @GetMapping("/getCount")
    public @ResponseBody long getCount() {
        return personService.getCount();
    }

}
