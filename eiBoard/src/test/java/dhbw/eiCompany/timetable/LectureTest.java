package dhbw.eiCompany.timetable;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LectureTest {
    Lecture lecture1;

    @BeforeEach
    void setUp() {
        lecture1 = new Lecture(
                "testLecturer",
                "testRoom",
                "testLecture",
                LocalDateTime.now(),
                LocalDateTime.now().plusDays(1),
                LocalDate.now()
        );
    }

    @Test
    @Order(1)
    void getLecturer() {
        assertEquals("testLecturer", lecture1.getLecturer());
    }

    @Test
    @Order(2)
    void setLecturer() {
        lecture1.setLecturer("Julian Stadler");
        assertEquals("Julian Stadler", lecture1.getLecturer());
    }

    @Test
    @Order(3)
    void getRoom() {
        assertEquals("testRoom", lecture1.getRoom());
    }

    @Test
    @Order(4)
    void setRoom() {
        lecture1.setRoom("Wohnzimmer");
        assertEquals("Wohnzimmer", lecture1.getRoom());
    }

    @Test
    @Order(5)
    void getLecture() {
        assertEquals("testLecture", lecture1.getLecture());
    }

    @Test
    @Order(6)
    void setLecture() {
        lecture1.setLecture("Compilerbau");
        assertEquals("Compilerbau", lecture1.getLecture());
    }

    @Test
    @Order(7)
    void getStart() {
        assertEquals(LocalDateTime.now(), lecture1.getStart());
    }

    @Test
    @Order(8)
    void setStart() {
        lecture1.setStart(LocalDateTime.of(2022, 12, 12,12,12,12));
        assertEquals(LocalDateTime.of(2022,12,12,12,12,12), lecture1.getStart());
    }

    @Test
    @Order(9)
    void getEnd() {
        assertEquals(LocalDateTime.now().plusDays(1), lecture1.getEnd());
    }

    @Test
    @Order(10)
    void setEnd() {
        lecture1.setStart(LocalDateTime.of(2022, 12, 12,12,12,12));
        assertEquals(LocalDateTime.of(2022,12,12,12,12,12), lecture1.getStart());
    }

    @Test
    @Order(11)
    void getDate() {
        assertEquals(LocalDate.now(), lecture1.getDate());
    }

    @Test
    @Order(12)
    void setDate() {
        lecture1.setDate(LocalDate.of(2022,12,12));
        assertEquals(LocalDate.of(2022,12,12), lecture1.getDate());
    }
}