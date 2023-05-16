package dhbw.eiCompany.timetable;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleDayTest {
    ScheduleDay testDay = new ScheduleDay();
    Lecture lecture1;
    Lecture lecture2;
    private List<Lecture> testLectureList = new ArrayList<Lecture>();

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

        lecture2 = new Lecture(
                "Mr.Eisenbiegler",
                "F419",
                "Compilerbau",
                LocalDateTime.now(),
                LocalDateTime.now().plusDays(1),
                LocalDate.now()
        );

    }

    @Test
    void addLecture() {
        testDay.addLecture(lecture1);
        testDay.addLecture(lecture2);

        assertEquals(testLectureList.size(), 0);
    }

    @Test
    void getLectureList() {
    }

    @Test
    void clearAll() {
    }
}