package com.hcl.personservice.service;

import com.hcl.personservice.dao.PersonDaoService;
import com.hcl.personservice.entity.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    final PersonDaoService personDaoService;


    public PersonService(PersonDaoService personDaoService) {
        this.personDaoService = personDaoService;
    }

    public List<Person> GetAll() {
        return personDaoService.GetAll();
    }


    public Optional<Person> getOneById(int id) {
        final Optional<Person> optionalPerson = personDaoService.getOneById(id);

        return optionalPerson;
    }

    public List<Person> resposeEntityGetAll() {

        return personDaoService.resposeEntityGetAll();

    }

    public Object resposeEntityObjectGetAll() {
        return ResponseEntity.ok(personDaoService.resposeEntityObjectGetAll());
    }

    public Optional<Person> create(Person person) {
        final Optional<Person> optionalPerson = personDaoService.create(person);
        return optionalPerson;
    }

    public Optional<Person> ResponseEntitycreate(Person person) {
        final Optional<Person> optionalPerson = personDaoService.ResponseEntitycreate(person);
        return optionalPerson;
    }

    public Optional<Person> update(Person person) {

        final Optional<Person> optionalPerson = personDaoService.update(person);
        System.out.println(person.getName() + "User Created successfully");
        return optionalPerson;
    }

    public Optional<Person> ResponseEntityupdate(Person person) {

        final Optional<Person> optionalPerson = personDaoService.ResponseEntityupdate(person);
        return optionalPerson;
    }

    public boolean delete(int id) {
        return personDaoService.delete(id);
    }

    public ResponseEntity<Object> ResponseEntitydelete(int id) {
        personDaoService.ResponseEntitydelete(id);
        return ResponseEntity.noContent().build();
    }


}