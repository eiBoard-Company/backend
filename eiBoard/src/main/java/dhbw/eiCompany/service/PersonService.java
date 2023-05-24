package dhbw.eiCompany.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dhbw.eiCompany.model.Event;
import dhbw.eiCompany.model.Person;
import dhbw.eiCompany.model.Task;
import dhbw.eiCompany.repositories.UsersRepository;

@Service
public class PersonService {

    @Autowired
    UsersRepository usersRepository;

    
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

	public Person findById(Long id) {
		return usersRepository.findById(id).get();
	}
	
	public List<Task> getTasks(Long id) {
		return findById(id).getTasks();
	}
	public List<Event> getEvents(Long id) {
		return findById(id).getEvents();
	}
    
}
