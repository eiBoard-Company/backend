package dhbw.eiCompany.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dhbw.eiCompany.model.Person;
import dhbw.eiCompany.repositories.UsersRepository;

@Service
public class PersonServiceImp implements PersonService{

    @Autowired
    UsersRepository usersRepository;

    @Override
    public Person findByName(String name) {
        return usersRepository.findByName(name);
    }

    public List<Person> getAllUser(){

        return new ArrayList<>(usersRepository.findAll());
    }

    public Person saveOrUpdate(Person name){
       return usersRepository.save(name);
    }

    public void deleteById(Long id){
        usersRepository.deleteById(id);
    }

	@Override
	public Person findById(Long id) {
		return usersRepository.findById(id).get();
	}
    
    
}
