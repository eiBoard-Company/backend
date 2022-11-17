package dhbw.eiCompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dhbw.eiCompany.database.Person;
import dhbw.eiCompany.repositories.UsersRepository;

@RestController
public class UserController {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping(path ="/user/{name}")
    public Person users(@PathVariable String name){
        return usersRepository.findByName(name);
    }

}