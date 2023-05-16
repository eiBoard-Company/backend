package dhbw.eiCompany.timetable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
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
    void getLecturer() {
        assertEquals("testLecturer", lecture1.getLecturer());
    }

    @Test
    void setLecturer() {
        lecture1.setLecturer("Julian Stadler");
        assertEquals("Julian Stadler", lecture1.getLecturer());
    }

    @Test
    void getRoom() {
        assertEquals("testRoom", lecture1.getRoom());
    }

    @Test
    void setRoom() {
        lecture1.setRoom("Wohnzimmer");
        assertEquals("Wohnzimmer", lecture1.getRoom());
    }

    @Test
    void getLecture() {
        assertEquals("testLecture", lecture1.getLecture());
    }

    @Test
    void setLecture() {
        lecture1.setLecture("Compilerbau");
        assertEquals("Compilerbau", lecture1.getLecture());
    }

    @Test
    void getStart() {
        assertEquals(LocalDateTime.now(), lecture1.getStart());
    }

    @Test
    void setStart() {
        lecture1.setStart(LocalDateTime.now().plusMinutes(30L));
        assertEquals(LocalDateTime.now().plusMinutes(30L), lecture1.getStart());
    }

    @Test
    void getEnd() {
        assertEquals(LocalDateTime.now().plusDays(1), lecture1.getEnd());
    }

    @Test
    void setEnd() {
        lecture1.setEnd(LocalDateTime.now().plusDays(2));
        assertEquals(LocalDateTime.now().plusDays(2), lecture1.getEnd());
    }

    @Test
    void getDate() {
        assertEquals(LocalDate.now(), lecture1.getDate());
    }

    @Test
    void setDate() {
        lecture1.setDate(LocalDate.of(2022,12,12));
        assertEquals(LocalDate.of(2022,12,12), lecture1.getDate());
    }
}