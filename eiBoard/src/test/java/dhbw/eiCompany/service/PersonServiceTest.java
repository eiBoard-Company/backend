package dhbw.eiCompany.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import dhbw.eiCompany.model.Event;
import dhbw.eiCompany.model.Task;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import dhbw.eiCompany.configuration.Credentials;
import dhbw.eiCompany.configuration.KeycloakAdminclient;
import dhbw.eiCompany.dto.PersonDTO;
import dhbw.eiCompany.mapper.PersonMapper;
import dhbw.eiCompany.model.Person;
import dhbw.eiCompany.repositories.UsersRepository;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonServiceTest {

    @Mock
    private UsersRepository usersRepository;

    @Mock
    private PersonMapper personMapper;

    @Mock
    private UsersResource usersResource;

    @Mock
    private KeycloakAdminclient keycloakAdminclient;

    @InjectMocks
    private PersonService personService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Order(1)
    public void testGetAllUser() {
        // Mocking
        List<Person> users = new ArrayList<>();
        when(usersRepository.findAll()).thenReturn(users);

        // Test
        List<Person> result = personService.getAllUser();

        // Assertion
        assertEquals(users, result);
    }

    @Test
    @Order(2)
    public void testUpdate() {
        // Mocking
        Person person = new Person();
        when(usersRepository.save(person)).thenReturn(person);

        // Test
        Person result = personService.update(person);

        // Assertion
        assertEquals(person, result);
        verify(usersRepository, times(1)).save(person);
    }

    @Test
    @Order(3)
    public void testDeleteById() {
        // Test
        assertDoesNotThrow(() -> personService.deleteById(1L));

        // Verification
        verify(usersRepository, times(1)).deleteById(1L);
    }

    @Test
    @Order(4)
    public void testFindById() {
        // Mocking
        Long personId = 1L;
        Person person = new Person();
        when(usersRepository.findById(personId)).thenReturn(Optional.of(person));

        // Test
        Person result = personService.findById(personId);

        // Assertion
        assertEquals(person, result);
    }

    @Test
    @Order(5)
    public void testGetTasks() {
        // Mocking
        Long personId = 1L;
        Person person = new Person();
        List<Task> tasks = new ArrayList<>();
        person.setTasks(tasks);
        when(usersRepository.findById(personId)).thenReturn(Optional.of(person));

        // Test
        List<Task> result = personService.getTasks(personId);

        // Assertion
        assertEquals(tasks, result);
    }

    @Test
    @Order(6)
    public void testGetEvents() {
        // Mocking
        Long personId = 1L;
        Person person = new Person();
        List<Event> events = new ArrayList<>();
        person.setEvents(events);
        when(usersRepository.findById(personId)).thenReturn(Optional.of(person));

        // Test
        List<Event> result = personService.getEvents(personId);

        // Assertion
        assertEquals(events, result);
    }
}
