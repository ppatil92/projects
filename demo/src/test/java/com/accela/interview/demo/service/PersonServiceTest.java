package com.accela.interview.demo.service;

import com.accela.interview.demo.entity.Person;
import com.accela.interview.demo.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test with actual context laod with h2
 */
@SpringBootTest
class PersonServiceTest {

	@Autowired
	private PersonService personService;

	@Test
	void addPerson_success_add() {
		Person p = new Person("prathamesh","patil");
		Person dbPerson = personService.addPerson(p).getBody();
		assert dbPerson.getLastName().equals("patil");
	}

}
