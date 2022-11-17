package dhbw.eiCompany.controller;

import dhbw.eiCompany.database.User;
import dhbw.eiCompany.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping(path ="/user/{name}")
    public User users(@PathVariable String name){
        return usersRepository.findByName(name);
    }

}