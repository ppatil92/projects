package com.accela.interview.demo.service;

import com.accela.interview.demo.entity.Person;
import com.accela.interview.demo.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public long getCount() {
        return personRepository.count();
    }

    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    public ResponseEntity<Person> getPersonById(String id) {
        ResponseEntity<Person> p = null;
        try {
            long inputId = Long.parseLong(id);
            Optional<Person> person = personRepository.findById(inputId);

            if (person.isPresent()) {
                return new ResponseEntity<Person>(person.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e) {
            log.error(e.getMessage());
        }
        return p;
    }


    @Transactional
    public ResponseEntity<Person> editPerson(Person person) {
        try {
             Person dbPerson = personRepository.getById(person.getId());
             dbPerson.setFirstName(person.getFirstName());
             dbPerson.setLastName(person.getLastName());
            Person _person = personRepository.save(dbPerson);
            log.info("update success");
            return new ResponseEntity<>(_person, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @Transactional
    public ResponseEntity<Person> addPerson(Person person) {
        try {
            Person _person = personRepository
                    .save(new Person(person.getFirstName() ,person.getLastName()));
            log.info("save person success");
            return new ResponseEntity<>(_person, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    public void deletePersonById(String id) throws Exception {
        long inputId = Long.parseLong(id);
        personRepository.findById(inputId).map(person -> {
            personRepository.delete(person);
            log.info("delete success");
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new Exception("id " + id + " not found"));
    }

}
