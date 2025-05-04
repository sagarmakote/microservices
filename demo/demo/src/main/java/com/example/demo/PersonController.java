package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
    private List<Person> people =new ArrayList<>(Arrays.asList(
            new Person(222,"Balram"),
            new Person(333,"Chaitanya"),
            new Person(444,"Douji"),
            new Person(555,"Eravat"),
            new Person(666,"Fanas"),
            new Person(777,"Govind")
    ));

    @GetMapping("/getAll")
    public List<Person> getAll(){
        return people;
    }

    @GetMapping("/getOneById/{id}")
    public Person getOneById(@PathVariable int id){
        final Optional<Person> optionalPerson = people.stream().filter(person -> person.getId() == id).findFirst();
        return optionalPerson.orElse(null);
    }

    @PostMapping("/create")
    public Person create(@RequestBody Person person){
        people.add(person);
        final Optional<Person> optionalPerson=people.stream().filter(p -> p.getId() == person.getId()).findFirst();
        return optionalPerson.orElse(null);
    }

    @PutMapping("/update")
    public Person update(@RequestBody Person person){
        //removing exiting person
        people.removeIf(p->p.getId()==person.getId());
        //add new person
        people.add(person);
        final Optional<Person> optionalPerson=people.stream().filter(p -> p.getId() == person.getId()).findFirst();
        System.out.println(person.getName()+"User Created successfully");
        return optionalPerson.orElse(null);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        people.removeIf(p->p.getId()==id);
    }
}
