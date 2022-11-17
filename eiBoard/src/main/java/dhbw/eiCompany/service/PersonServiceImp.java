package dhbw.eiCompany.service;

import dhbw.eiCompany.database.Person;
import dhbw.eiCompany.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImp implements PersonService{

    @Autowired
    UsersRepository usersRepository;

    @Override
    public String findByName(String name) {
        return name;
    }

    public List<Person> getAllUser(){

        return new ArrayList<Person>(usersRepository.findAll());
    }

    public void saveOrUpdate(Person name){
        usersRepository.save(name);
    }

    public void delete(Person name){
        usersRepository.delete(name);
    }
}
