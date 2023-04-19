package dhbw.eiCompany.interfaces;

import dhbw.eiCompany.database.Person;

import java.util.List;

public interface PersonService {

    Person findByName(String name);
    List<Person> getAllUser();
    void saveOrUpdate(Person name);
    void delete(Person name);

}
