package com.hcl.personservice.repository;

import com.hcl.personservice.entity.Person;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PersonRepository {
    public List<Person> people = new ArrayList<>(Arrays.asList(
            new Person(222, "Balram"),
            new Person(333, "Chaitanya"),
            new Person(444, "Douji"),
            new Person(555, "Eravat"),
            new Person(666, "Fanas"),
            new Person(777, "Govind")
    ));
    public List<Person> GetAll() {
        return people;
    }

    public Optional<Person> getOneById(int id) {
        final Optional<Person> optionalPerson = people.stream()
                .filter(person1 -> person1.getId() == id).findFirst();
        return optionalPerson;
    }

    public List<Person> resposeEntityGetAll() {
        return people;
    }

    public Object resposeEntityObjectGetAll() {
        return ResponseEntity.ok(people);
    }

    public Optional<Person> create(Person person) {
        final Optional<Person> optionalPerson = people.stream()
                .filter(person1 -> person1.getId() == person.getId()).findFirst();
        return optionalPerson;
    }

    public Optional<Person> ResponseEntitycreate(Person person) {
        final Optional<Person> optionalPerson = people.stream()
                .filter(person1 -> person1.getId() == person.getId()).findFirst();
        return optionalPerson;
    }

    public Optional<Person> update(Person person) {
        //removing exiting person
        people.removeIf(p -> p.getId() == person.getId());
        //add new person
        people.add(person);
        final Optional<Person> optionalPerson = people.stream().filter(p -> p.getId() == person.getId()).findFirst();
        System.out.println(person.getName() + "User Created successfully");
        return optionalPerson;
    }

    public Optional<Person> ResponseEntityupdate(Person person) {
        //removing exiting person
        people.removeIf(p -> p.getId() == person.getId());
        //add new person
        people.add(person);
        final Optional<Person> optionalPerson = people.stream().filter(p -> p.getId() == person.getId()).findFirst();
        return optionalPerson;
    }

    public boolean delete(int id) {
        return people.removeIf(p -> p.getId() == id);
    }

    public ResponseEntity<Object> ResponseEntitydelete(int id) {
        people.removeIf(p -> p.getId() == id);
        return ResponseEntity.noContent().build();
    }
}
