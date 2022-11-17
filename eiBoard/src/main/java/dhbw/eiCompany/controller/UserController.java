package dhbw.eiCompany.controller;

import dhbw.eiCompany.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import dhbw.eiCompany.database.Person;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    PersonService personService;

    @GetMapping(path ="/user/{name}")
    public Person users(@PathVariable String name){
        return personService.findByName(name);
    }

    @GetMapping(path = "/user")
    public List<Person> getAllUser(){
        return personService.getAllUser();
    }

    @DeleteMapping("/user/{name}")
    private void deleteUser(@PathVariable("name") Person name){
        personService.delete(name);
    }

    @PostMapping(path="/user")
    private Long saveUser(@RequestBody Person name){
        personService.saveOrUpdate(name);
        return name.getUserId();
    }
}