package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

@RestController
class HelloController{

	@GetMapping("/getData")
	public String getData(){

		return "<h1>Get Data</h1>";
	}
	@GetMapping("/putData")
	public String putData(){

		return "<h1>Get putData</h1>";
	}
	@GetMapping("/deleteData")
	public String deleteData(){

		return "<h1>Get deleteData</h1>";
	}
	@GetMapping("/patchData")
	public String patchData(){

		return "<h1>Get patchData</h1>";
	}
	@GetMapping(value = "/personXmlData")
	public Person personXmlData(){
		return new Person(111,"Sagar Makote");
	}

	@GetMapping(value = "/personJsonData",produces = MediaType.APPLICATION_JSON_VALUE)
	public Person personJsonData(){
		return new Person(111,"Sagar Prashant");
	}

}

class Person{

	private int id;
	private String name;

	Person(int id,String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}