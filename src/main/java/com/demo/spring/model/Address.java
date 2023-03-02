package com.demo.spring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String street;

    @Column
    @NotNull
    private String zipcode;

    @Column
    @NotNull
    private String number;

    @Column
    @NotNull
    private String city;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Column(name = "is_main")
    private boolean main;

    public Address() {
    }

    public Address(Long id, String street, String zipcode, String number, String city, Person person, boolean main) {
        this.id = id;
        this.street = street;
        this.zipcode = zipcode;
        this.number = number;
        this.city = city;
        this.person = person;
        this.main = main;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public boolean isMain() {
        return main;
    }

    public void setMain(boolean main) {
        this.main = main;
    }
}
