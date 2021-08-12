package com.accela.interview.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long addressid;

    @Column(name = "street")
    private String street;

    @Column(name = "state")
    private String state;

    @Column(name = "postalcode")
    private String postalCode;

    @Column(name = "city")
    private String city;
}
