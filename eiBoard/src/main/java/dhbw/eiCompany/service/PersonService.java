package dhbw.eiCompany.service;

import dhbw.eiCompany.database.Person;

import java.util.List;

public interface PersonService {

    String findByName(String name);
    List<Person> getAllUser();
    void saveOrUpdate(Person name);
    void delete(Person name);

}
