package dhbw.eiCompany.timetable;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ScheduleDayTest {
    ScheduleDay testDay = new ScheduleDay();
    Lecture lecture1 = new Lecture(
            "testLecturer",
            "testRoom",
            "testLecture",
            LocalDateTime.now(),
            LocalDateTime.now().plusDays(1),
            LocalDate.now()
    );;
    Lecture lecture2 = new Lecture(
            "Mr.Eisenbiegler",
            "F419",
            "Compilerbau",
            LocalDateTime.now(),
            LocalDateTime.now().plusDays(1),
            LocalDate.now()
    );

    @BeforeEach
    void setUp() {
        testDay.addLecture(lecture1);
        testDay.addLecture(lecture2);
    }

    @Test
    void addLecture() {
        assertEquals(2, testDay.getLectureList().size());
    }

    @Test
    void getLectureList() {
        List<Lecture> testLectureList1 = new ArrayList<Lecture>();
        testLectureList1.add(lecture1);
        testLectureList1.add(lecture2);

        List<Lecture> testLectureList2 = new ArrayList<Lecture>();

        assertThat(testDay.getLectureList())
                .isEqualTo(testLectureList1)
                .isNotEqualTo(testLectureList2);
    }

    @Test
    void clearAll() {
        testDay.clearAll();

        assertEquals(0, testDay.getLectureList().size());
    }
}