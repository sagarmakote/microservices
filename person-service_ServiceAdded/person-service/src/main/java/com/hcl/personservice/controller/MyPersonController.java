package com.hcl.personservice.controller;

import com.hcl.personservice.entity.Person;
import com.hcl.personservice.service.PersonService;
import org.eclipse.jetty.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personservice/vi/persons")
public class MyPersonController {

    private final PersonService personservice;

    public MyPersonController(PersonService personservice) {
        this.personservice = personservice;
    }

    @GetMapping("/getAll")
    public List<Person> getAll() {
        return personservice.GetAll();
    }

    @GetMapping("/resposeEntityGetAll")
    public ResponseEntity<List<Person>> resposeEntityGetAll() {
        return ResponseEntity.ok(personservice.resposeEntityGetAll());
    }

    @GetMapping("/resposeEntityObjectGetAll")
    public ResponseEntity<List<Person>> resposeEntityObjectGetAll() {
        return new ResponseEntity(personservice.resposeEntityObjectGetAll(), HttpStatusCode.valueOf(HttpStatus.OK_200));
    }

    @GetMapping("/getOneById/{id}")
    public Person getOneById(@PathVariable int id) {
        final Optional<Person> optionalPerson = personservice.getOneById(id);
        return optionalPerson.orElse(null);

    }

    @GetMapping("/getOneByResponseEntityId/{id}")
    public ResponseEntity<Person> getOneByResponseEntityId(@PathVariable int id) {

        final Optional<Person> optionalPerson = personservice.getOneById(id);

        if (optionalPerson.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(optionalPerson.get());
        }
    }


    @PostMapping("/create")
    public Person create(@RequestBody Person person) {

        final Optional<Person> optionalPerson = personservice.create(person);

        return optionalPerson.orElse(null);
    }

    @PostMapping("/ResponseEntitycreate")
    public ResponseEntity<Person> ResponseEntitycreate(@RequestBody Person person) {
        final Optional<Person> optionalPerson = personservice.ResponseEntitycreate(person);

        if (optionalPerson.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(optionalPerson.get(), HttpStatusCode.valueOf(HttpStatus.CREATED_201));

    }

    @PutMapping("/update")
    public Person update(@RequestBody Person person) {

        final Optional<Person> optionalPerson = personservice.update(person);


        System.out.println(person.getName() + "User Created successfully");
        return optionalPerson.orElse(null);
    }

    @PutMapping("/ResponseEntityupdate")
    public ResponseEntity<Person> ResponseEntityupdate(@RequestBody Person person) {
        final Optional<Person> optionalPerson = personservice.ResponseEntityupdate(person);


        System.out.println(person.getName() + "User Created successfully");
        if (optionalPerson.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(optionalPerson.get(), HttpStatusCode.valueOf(HttpStatus.OK_200));
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id) {

        return personservice.delete(id);


    }

    @DeleteMapping("/ResponseEntitydelete/{id}")
    public ResponseEntity<Void> ResponseEntitydelete(@PathVariable int id) {
        personservice.ResponseEntitydelete(id);
        return ResponseEntity.noContent().build();
    }
}
