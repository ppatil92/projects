package com.accela.interview.demo.repository;

import com.accela.interview.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Person, Long> {
}
