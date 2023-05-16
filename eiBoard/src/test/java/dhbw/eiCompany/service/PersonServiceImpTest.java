package dhbw.eiCompany.service;

import dhbw.eiCompany.model.Person;
import dhbw.eiCompany.repositories.UsersRepository;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PersonServiceImpTest {
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    PersonService personService;

    Person person1 = new Person();
    Person person2 = new Person();

    @BeforeEach
    void setUp() {
        person1.setName("testPerson1");
        person1.setPassword("1234567890");
        person1.setEmail("test1@email.com");
        person1.setPicture("picture1");
        person1.setDescription("testDescription1");
        person1.setRang(null);
        person1.setEntryId("testEntryId1");

        person2.setName("testPerson2");
        person2.setPassword("1234567890");
        person2.setEmail("test2@email.com");
        person2.setPicture("picture2");
        person2.setDescription("testDescription2");
        person2.setRang(null);
        person2.setEntryId("testEntryId2");

    }

    @AfterEach
    void flush() {
        usersRepository.flush();
    }


    @Test
    @Order(1)
    void saveOrUpdate() {
        personService.saveOrUpdate(person1);
        personService.saveOrUpdate(person2);

        assertEquals(5, personService.getAllUser().size());

        Person person3 = new Person();
        person3.setName("testPerson3");
        person3.setPassword("sddasdfwefs");
        person3.setEmail("test3@email.com");
        person3.setPicture("picture3");
        person3.setDescription("testDescription3");
        person3.setRang(null);
        person3.setEntryId("testEntryId3");

        personService.saveOrUpdate(person3);
        assertEquals(6, personService.getAllUser().size());

    }

    @Test
    @Order(2)
    void findByName() {

        Person searchedPerson = personService.findByName("testPerson1");

        assertEquals(person1.getName(), searchedPerson.getName());

    }

    @Test
    void getAllUser() {
        assertInstanceOf(ArrayList.class, personService.getAllUser());
        assertEquals(6, personService.getAllUser().size());
    }


    @Test
    void deleteById() {
        assertEquals(6, personService.getAllUser().size());

        personService.deleteById(7L);

        assertEquals(5, personService.getAllUser().size());
        assertThrows(NoSuchElementException.class, ()->{
            personService.findById(7L);
        });

    }

    @Test
    void findById() {
        Person result = personService.findById(8L);
        Optional<Person> searchedPerson = usersRepository.findById(8L);

        assertTrue(EqualsBuilder.reflectionEquals(searchedPerson.get().getUserId(), result.getUserId()));
    }
}