package dhbw.eiCompany.service;

import java.util.List;

import dhbw.eiCompany.model.Person;

public interface PersonService {

    Person findByName(String name);
    Person findById(Long id);
    List<Person> getAllUser();
    Person saveOrUpdate(Person name);
    void deleteById(Long id);

}
