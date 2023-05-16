package dhbw.eiCompany.service;

import dhbw.eiCompany.model.Entry;
import dhbw.eiCompany.model.Person;
import dhbw.eiCompany.repositories.EntryRepository;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Order;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.TestMethodOrder;

import java.awt.*;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EntryServiceImpTest {

   @Autowired
   EntryRepository entryRepository;
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
        entryRepository.flush();
    }


    @Test
    @Order(1)
    void save() {

        Entry savedEntry1 = service.save(testEntry1);
        Entry savedEntry2 = service.save(testEntry2);
        Entry savedEntry3 = service.save(testEntry3);


        // For testEntry1
        assertEquals(savedEntry1.getEntryId(), testEntry1.getEntryId());
        assertEquals(savedEntry1.getName(), testEntry1.getName());
        assertEquals(savedEntry1.getPerson(), testEntry1.getPerson());
        assertEquals(savedEntry1.getColor(), testEntry1.getColor());
        assertEquals(savedEntry1.getDate(), testEntry1.getDate());
        assertEquals(savedEntry1.getDescription(), testEntry1.getDescription());
        assertEquals(savedEntry1.getCategory(), testEntry1.getCategory());
        assertEquals(savedEntry1.getTypId(), testEntry1.getTypId());

        // For testEntry2
        assertEquals(savedEntry2.getEntryId(), testEntry2.getEntryId());
        assertEquals(savedEntry2.getName(), testEntry2.getName());
        assertEquals(savedEntry2.getPerson(), testEntry2.getPerson());
        assertEquals(savedEntry2.getColor(), testEntry2.getColor());
        assertEquals(savedEntry2.getDate(), testEntry2.getDate());
        assertEquals(savedEntry2.getDescription(), testEntry2.getDescription());
        assertEquals(savedEntry2.getCategory(), testEntry2.getCategory());
        assertEquals(savedEntry2.getTypId(), testEntry2.getTypId());


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

        Entry result = service.findById(8L);
        Optional<Entry> searchedEntry = entryRepository.findById(8L);

        assertTrue(EqualsBuilder.reflectionEquals(searchedEntry.get().getEntryId(), result.getEntryId()));
    }

    @Test
    @Order(5)
    void getAllEntries() {

        List<Entry> allEntries = service.getAllEntries();

        assertEquals(4, allEntries.size());
    }

}