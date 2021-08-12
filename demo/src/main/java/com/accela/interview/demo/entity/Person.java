package com.accela.interview.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Entity
@Table(name = "person")
@Data
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "firstname")
    private String firstName;


    @Column(name = "lastname")
    private String lastName;
}
