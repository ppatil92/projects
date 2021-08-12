package com.accela.interview.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id",referencedColumnName="id")
    @JsonIgnoreProperties("addressList")
    private Person person;


}
