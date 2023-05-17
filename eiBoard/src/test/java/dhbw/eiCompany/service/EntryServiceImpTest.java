package dhbw.eiCompany.service;

import dhbw.eiCompany.model.Entry;
import dhbw.eiCompany.model.Person;
import dhbw.eiCompany.repositories.EntryRepository;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Order;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.awt.*;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static reactor.core.publisher.Mono.when;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EntryServiceImpTest {

   @Mock
   EntryRepository entryRepositoryMock;

   @Autowired
   EntryService service;

   Entry testEntry1 = new Entry();

   Entry testEntry2 = new Entry();
   Entry testEntry3 = new Entry();

    Person testPerson1 = new Person(
            1L,
            "Julian Stadler",
            "1234567890",
            "julian@email.com",
            "pictureJulian",
            "beschreibungJulian",
            null,
            "entryIdJulian"
    );

    Person testPerson2 = new Person(
            2L,
            "Matteo Staar",
            "ABCDEFGHIJ",
            "matteo@email.com",
            "pictureMatteo",
            "beschreibungMatteo",
            null,
            "entryIdMatteo"
    );



    @BeforeEach
    void setUp() {

        testEntry1.setName("testName1");
        testEntry1.setPerson(testPerson1);
        testEntry1.setColor(Color.GREEN);
        testEntry1.setDate(LocalDate.now());
        testEntry1.setDescription("testDescription1");
        testEntry1.setCategory("testCategory1");
        testEntry1.setTypId("testTypId1");

        testEntry2.setName("testName2");
        testEntry2.setPerson(testPerson2);
        testEntry2.setColor(Color.BLUE);
        testEntry2.setDate(LocalDate.now().plusDays(1));
        testEntry2.setDescription("testDescription2");
        testEntry2.setCategory("testCategory2");
        testEntry2.setTypId("testTypId2");

        testEntry3.setName("testName3");
        testEntry3.setPerson(testPerson1);
        testEntry3.setColor(Color.RED);
        testEntry3.setDate(LocalDate.now().plusDays(1));
        testEntry3.setDescription("testDescription3");
        testEntry3.setCategory("testCategory3");
        testEntry3.setTypId("testTypId3");
    }

    @AfterEach
    void flush(){
        entryRepositoryMock.flush();
    }

    private void assertEqualsEntry(Entry expected, Entry actual){
        assertEquals(expected.getEntryId(), actual.getEntryId());

    }


    @Test
    @Order(1)
    void save() {

        Entry savedEntry1 = service.save(testEntry1);
        Entry savedEntry2 = service.save(testEntry2);
        Entry savedEntry3 = service.save(testEntry3);

        assertEqualsEntry(savedEntry1, testEntry1);
        assertEqualsEntry(savedEntry2, testEntry2);
        assertEqualsEntry(savedEntry3, testEntry3);

    }

    @Test
    @Order(2)
    void delete() {

        //Hier wird Liste erstellt nachdem alle Objekte hinzugefügt wurden
        List<Entry> listBeforeDelete = service.getAllEntries();
        assertEquals(5, listBeforeDelete.size());

        service.delete(7L);

        /*
          Anschließend wird Liste nachdem Löschen eines Eintrags ausgegeben und überprüft
          ob die Liste sich verkleinert hat und ob eine Exception kommt wenn man nach dem
          gelöschten Objekt sucht
         */

        List<Entry> listAfterDelete = service.getAllEntries();

        assertEquals(4, listAfterDelete.size());

        assertThrows(NoSuchElementException.class, ()->{
            service.findById(7L);
        });
    }

    @Test
    @Order(3)
    void findById() {
        Entry expectedEntry = new Entry();
        expectedEntry.setEntryId(8L);

        Mockito.when(entryRepositoryMock.findById(8L)).thenReturn(Optional.of(expectedEntry));

        Entry result = service.findById(8L);

        assertEqualsEntry(expectedEntry, result);
    }


    @Test
    @Order(5)
    void getAllEntries() {

        List<Entry> allEntries = service.getAllEntries();

        assertEquals(4, allEntries.size());
    }

}