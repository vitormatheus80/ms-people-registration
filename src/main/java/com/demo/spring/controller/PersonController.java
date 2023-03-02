package com.demo.spring.controller;

import java.util.List;

import com.demo.spring.model.Address;
import com.demo.spring.model.Person;
import com.demo.spring.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person createdPerson = personService.createPerson(person);
        return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person person) {
        Person updatedPerson = personService.updatePerson(id, person);
        return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id) {
        Person person = personService.getPersonById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> persons = personService.getAllPersons();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @PostMapping("/{id}/addresses")
    public ResponseEntity<Address> createAddress(@PathVariable Long id, @RequestBody Address address) {
        Address createdAddress = personService.createAddressForPerson(id, address);
        return new ResponseEntity<>(createdAddress, HttpStatus.CREATED);
    }

    @GetMapping("/{id}/addresses")
    public ResponseEntity<List<Address>> getAllAddresses(@PathVariable Long id) {
        List<Address> addresses = personService.getAllAddressesForPerson(id);
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @GetMapping("/{id}/addresses-main")
    public ResponseEntity<Address> getAddressMain(@PathVariable Long id) {
        Address addresses = personService.getAddressMain(id);
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @PutMapping("/{id}/addresses/{addressId}/set-main")
    public ResponseEntity<Void> setMainAddress(@PathVariable Long id, @PathVariable Long addressId) {
        personService.setMainAddressForPerson(id, addressId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
