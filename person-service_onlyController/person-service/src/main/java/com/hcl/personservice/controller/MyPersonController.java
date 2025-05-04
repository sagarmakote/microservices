package com.hcl.personservice.controller;

import com.hcl.personservice.entity.Person;
import org.eclipse.jetty.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personservice/vi/persons")
public class MyPersonController {
    public List<Person> people =new ArrayList<>(Arrays.asList(
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
    @GetMapping("/resposeEntityGetAll")
    public ResponseEntity<List<Person>> resposeEntityGetAll(){
        return  ResponseEntity.ok(people);
    }

    @GetMapping("/resposeEntityObjectGetAll")
    public ResponseEntity<List<Person>> resposeEntityObjectGetAll(){
        return  new ResponseEntity(people, HttpStatusCode.valueOf(HttpStatus.OK_200));
    }

    @GetMapping("/getOneById/{id}")
    public Person getOneById(@PathVariable int id){
        final Optional<Person> optionalPerson= people.stream()
                .filter(person->person.getId()==id).findFirst();
        return optionalPerson.orElse(null);

    }

    @GetMapping("/getOneByResponseEntityId/{id}")
    public ResponseEntity<Person> getOneByResponseEntityId(@PathVariable int id){

        final Optional<Person> optionalPerson= people.stream()
                .filter(person->person.getId()==id).findFirst();

        if(optionalPerson.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(optionalPerson.get());
        }
    }



    @PostMapping("/create")
    public Person create(@RequestBody Person person){
        people.add(person);
        final Optional<Person> optionalPerson= people.stream()
                .filter(person1 -> person1.getId()==person.getId()).findFirst();
        return optionalPerson.orElse(null);
    }

@PostMapping("/ResponseEntitycreate")
public ResponseEntity<Person> ResponseEntitycreate(@RequestBody Person person){
    people.add(person);
    final Optional<Person> optionalPerson= people.stream()
            .filter(person1 -> person1.getId()==person.getId()).findFirst();
    if(optionalPerson.isEmpty()) {
        return ResponseEntity.notFound().build();
    }
    return new ResponseEntity<>(optionalPerson.get(), HttpStatusCode.valueOf(HttpStatus.CREATED_201));

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

    @PutMapping("/ResponseEntityupdate")
    public ResponseEntity<Person> ResponseEntityupdate(@RequestBody Person person){
        //removing exiting person
        people.removeIf(p->p.getId()==person.getId());
        //add new person
        people.add(person);
        final Optional<Person> optionalPerson=people.stream().filter(p -> p.getId() == person.getId()).findFirst();
        System.out.println(person.getName()+"User Created successfully");
        if(optionalPerson.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(optionalPerson.get(), HttpStatusCode.valueOf(HttpStatus.OK_200));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        people.removeIf(p->p.getId()==id);
    }

    @DeleteMapping("/ResponseEntitydelete/{id}")
    public ResponseEntity<Void> ResponseEntitydelete(@PathVariable int id){
        people.removeIf(p->p.getId()==id);
        return ResponseEntity.noContent().build();
    }
}
