package com.accela.interview.demo.service;

import com.accela.interview.demo.entity.Person;
import com.accela.interview.demo.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person getPersonById(String id) {
        Person p = null;
        try {
            long inputId = Long.parseLong(id);
          p =  personRepository.getById(inputId);
        }catch (Exception e) {
            log.error(e.getMessage());
        }
        return p;
    }

}
