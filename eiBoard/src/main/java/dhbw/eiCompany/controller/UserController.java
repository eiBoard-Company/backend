package dhbw.eiCompany.controller;

import dhbw.eiCompany.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dhbw.eiCompany.database.Person;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    PersonService personService;

    @GetMapping(path ="/user/{name}")
    public ResponseEntity<Person> users(@PathVariable String name){
        return new ResponseEntity<>(personService.findByName(name), HttpStatus.OK);
    }

    @GetMapping(path = "/user")
    public ResponseEntity<List<Person>> getAllUser(){
        return new ResponseEntity<>(personService.getAllUser(), HttpStatus.OK);
    }

    @DeleteMapping("/user/{name}")
    private ResponseEntity<Person> deleteUser(@PathVariable("name") Person name){
        personService.delete(name);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping(path="/user")
    private ResponseEntity<Long> saveUser(@RequestBody Person name){
        personService.saveOrUpdate(name);
        return new ResponseEntity<>(name.getUserId(), HttpStatus.ACCEPTED);
    }
}