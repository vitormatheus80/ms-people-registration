package com.demo.spring.service;

import com.demo.spring.model.Address;
import com.demo.spring.model.Person;
import com.demo.spring.repository.AnddressRepository;
import com.demo.spring.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AnddressRepository addressRepository;

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Person updatePerson(Long id, Person person) {
        Person existingPerson = getPersonById(id);
        existingPerson.setName(person.getName());
        existingPerson.setBirthdate(person.getBirthdate());
        return personRepository.save(existingPerson);
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Person not found with id " + id));
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Address createAddressForPerson(Long personId, Address address) {
        Person person = getPersonById(personId);
        address.setPerson(person);
        return addressRepository.save(address);
    }

    public List<Address> getAllAddressesForPerson(Long personId) {
        Person person = getPersonById(personId);
        return addressRepository.findByPersonId(personId);
    }

    public Address getAddressMain(Long personId){
        Person existingPerson = getPersonById(personId);
        return addressRepository.findByPersonIdAndMainIsTrue(personId);
    }

    public Address setMainAddressForPerson(Long personId, Long addressId) {
        Address existingMainAddress = addressRepository.findByPersonIdAndMainIsTrue(personId);
        if (existingMainAddress != null) {
            existingMainAddress.setMain(false);
            addressRepository.save(existingMainAddress);
        }
        Address newMainAddress = addressRepository.findById(addressId)
                .orElseThrow(() -> new EntityNotFoundException("Address not found with id " + addressId));
        newMainAddress.setMain(true);
        return addressRepository.save(newMainAddress);
    }
}

