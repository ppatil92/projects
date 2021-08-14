package com.accela.interview.demo.service;

import com.accela.interview.demo.entity.Address;
import com.accela.interview.demo.entity.Person;
import com.accela.interview.demo.repository.AddressRepository;
import com.accela.interview.demo.repository.PersonRepository;
import com.accela.interview.demo.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Test with actual context laod with h2
 */
@SpringBootTest
class PersonServiceTest {

	@Autowired
	private PersonService personService;

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private AddressService addressService;

	@Autowired
	private AddressRepository addressRepository;

	@Test
	public void addPerson_success_add() {
		Person p = new Person("prathamesh","patil");
		Person dbPerson = personService.addPerson(p).getBody();
		assert dbPerson.getLastName().equals("patil");
	}

}
