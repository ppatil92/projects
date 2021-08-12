package com.accela.interview.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "person")
@Data
@NoArgsConstructor
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "firstname")
    private String firstName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="person", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("person")
    private List<Address> addressList;


    @Column(name = "lastname")
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
