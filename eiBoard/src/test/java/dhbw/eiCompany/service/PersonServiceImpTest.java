//package dhbw.eiCompany.service;
//
//import dhbw.eiCompany.model.Person;
//import dhbw.eiCompany.repositories.UsersRepository;
//import org.apache.commons.lang3.builder.EqualsBuilder;
//import org.junit.jupiter.api.*;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class PersonServiceImpTest {
//    @Mock
//    private UsersRepository usersRepository;
//
//    @InjectMocks
//    PersonServiceImp personService;
//
//
//    @BeforeEach
//    void setUp() { MockitoAnnotations.initMocks(this); }
//
//    @AfterEach
//    void flush() {
//        usersRepository.flush();
//    }
//
//
//    @Test
//    @Order(1)
//    void saveOrUpdate() {
//        Person person = new Person();
//        when(usersRepository.save(person)).thenReturn(person);
//
//        Person savedPerson = personService.saveOrUpdate(person);
//
//        assertEquals(person, savedPerson);
//    }
//
//    @Test
//    @Order(2)
//    void findByName() {
//
//       String personName = "testName";
//       Person person = new Person();
//       when(usersRepository.findByName(personName)).thenReturn(person);
//
//       Person foundPerson = personService.findByName(personName);
//
//       assertEquals(foundPerson, person);
//    }
//
//    @Test
//    @Order(3)
//    void getAllUser() {
//
//        List<Person> personList = new ArrayList<>();
//        personList.add(new Person());
//        when(usersRepository.findAll()).thenReturn(personList);
//
//        List<Person> allPersons = personService.getAllUser();
//
//        assertEquals(personList.size(), allPersons.size());
//        assertEquals(personList.get(0), allPersons.get(0));
//    }
//
//
//    @Test
//    @Order(4)
//    void deleteById() {
//       Long personId = 1L;
//       personService.deleteById(personId);
//
//       assertEquals(0,usersRepository.findAll().size());
//
//    }
//
//    @Test
//    @Order(5)
//    void findById() {
//        Long personId = 1L;
//        Person person = new Person();
//        when(usersRepository.findById(personId)).thenReturn(Optional.of(person));
//
//        Person foundPerson = personService.findById(personId);
//
//        assertEquals(person, foundPerson);
//
//        when(usersRepository.findById(personId)).thenReturn(Optional.empty());
//
//        assertThrows(NoSuchElementException.class, () -> personService.findById(personId));
//    }
//}