package com.hcl.personservice.dao;

import com.hcl.personservice.entity.Person;
import com.hcl.personservice.repository.PersonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Service
public class PersonDaoService{
    final PersonRepository personRepository;

    public PersonDaoService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public List<Person> findAll() {
        return personRepository.findAll();
    }


    public Optional<Person> getOneById(int id) {
        final Optional<Person> optionalPerson = personRepository.getOneById(id);
        return optionalPerson;
    }

    public List<Person> resposeEntityGetAll() {

        return personRepository.resposeEntityGetAll();

    }

    public Object resposeEntityObjectGetAll() {
        return ResponseEntity.ok(personRepository.resposeEntityObjectGetAll());
    }

    public Optional<Person> create(Person person) {
        final Optional<Person> optionalPerson = personRepository.create(person);
        return optionalPerson;
    }

    public Optional<Person> ResponseEntitycreate(Person person) {
        final Optional<Person> optionalPerson = personRepository.ResponseEntitycreate(person);
        return optionalPerson;
    }

    public Optional<Person> update(Person person) {
        Optional<Person> optionalPerson = personRepository.update(person);
        System.out.println(person.getName() + "User Created successfully");
        return optionalPerson;
    }

    public Optional<Person> ResponseEntityupdate(Person person) {
        final Optional<Person> optionalPerson = personRepository.ResponseEntityupdate(person);
        return optionalPerson;
    }

    public boolean delete(int id) {
        return personRepository.delete(id);
    }

    public ResponseEntity<Object> ResponseEntitydelete(int id) {
        personRepository.ResponseEntitydelete(id);
        return ResponseEntity.noContent().build();
    }
}