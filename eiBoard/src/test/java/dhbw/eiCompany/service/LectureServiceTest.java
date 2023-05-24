package dhbw.eiCompany.service;

import dhbw.eiCompany.service.LectureService;
import dhbw.eiCompany.timetable.Lecture;
import dhbw.eiCompany.timetable.ScheduleDay;
import dhbw.timetable.rapla.data.event.Appointment;
import dhbw.timetable.rapla.exceptions.NoConnectionException;
import dhbw.timetable.rapla.parser.DataImporter;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LectureServiceTest {

    @Autowired
    private LectureService lectureService;
    private String url = "https://rapla.dhbw-karlsruhe.de/rapla?page=calendar&user=eisenbiegler&file=TINF21B4";

    @BeforeEach
    void setUp() {
        lectureService = new LectureService();
    }

    @Test
    @Order(1)
    void getDay() throws MalformedURLException, IllegalAccessException, NoConnectionException {
        // Arrange
        LocalDate date = LocalDate.of(2023, Month.MAY, 16);
        Map<LocalDate, ArrayList<Appointment>> data = new HashMap<>();
        Appointment appointment = new Appointment(LocalDateTime.of(2023, Month.MAY, 16, 9, 0),
                LocalDateTime.of(2023, Month.MAY, 16, 12, 15),
                "Statistik", "Rotzinger, Frank", "F492  Hörsaal,TINF21B4");
        data.put(date, new ArrayList<>(List.of(appointment)));
        DataImporter.ImportWeekRange(date, date.plusDays(1), url);

        // Act
        ScheduleDay scheduleDay = lectureService.getDay(date);

        // Assert
        Assertions.assertNotNull(scheduleDay);
        Assertions.assertEquals(1, scheduleDay.getLectureList().size());
        Lecture lecture = scheduleDay.getLectureList().get(0);
        Assertions.assertEquals("Rotzinger, Frank", lecture.getLecturer());
        Assertions.assertEquals("F492  Hörsaal,TINF21B4", lecture.getRoom());
        Assertions.assertEquals("Statistik", lecture.getLecture());
        Assertions.assertEquals(LocalDateTime.of(2023, Month.MAY, 16, 9, 0), lecture.getStart());
        Assertions.assertEquals(LocalDateTime.of(2023, Month.MAY, 16, 12, 15), lecture.getEnd());
        Assertions.assertEquals(LocalDate.of(2023, Month.MAY, 16), lecture.getDate());
    }

    @Test
    @Order(2)
    void getWeek() throws MalformedURLException, IllegalAccessException, NoConnectionException {
        // Arrange
        LocalDate date = LocalDate.of(2023, Month.MAY, 16);
        LocalDateTime monday = date.atStartOfDay().with(java.time.temporal.TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY));
        DataImporter.ImportWeekRange(monday.toLocalDate(), monday.toLocalDate(), url);
        Map<LocalDate, ArrayList<Appointment>> data = new HashMap<>();
        Appointment appointment1 = new Appointment(LocalDateTime.of(2023, Month.MAY, 16, 9, 0),
                LocalDateTime.of(2023, Month.MAY, 16, 12, 15),
                "Statistik", "Rotzinger, Frank", "F492  Hörsaal,TINF21B4");
        Appointment appointment2 = new Appointment(LocalDateTime.of(2023, Month.MAY, 19, 9, 0),
                LocalDateTime.of(2023, Month.MAY, 19, 12, 15),
                "Workflow", "Schöll, Oliver", "Room B");
        data.put(monday.toLocalDate(), new ArrayList<>(List.of(appointment1)));
        data.put(monday.plusDays(2).toLocalDate(), new ArrayList<>(List.of(appointment2)));
        DataImporter.ImportWeekRange(monday.toLocalDate(), monday.toLocalDate(), url);

        // Act
        List<ScheduleDay> scheduleWeek = lectureService.getWeek(date);

        // Assert
        Assertions.assertNotNull(scheduleWeek);
        Assertions.assertEquals(1, scheduleWeek.size());

        ScheduleDay scheduleDay1 = scheduleWeek.get(0);
        Assertions.assertEquals(6, scheduleDay1.getLectureList().size());
        Lecture lecture1 = scheduleDay1.getLectureList().get(0);
        Assertions.assertEquals("Braun, Heinrich,Lausen, Ralph,Freudenmann, Johannes,Vollmer, Jürgen,Strand, Marcus,Röthig, Jürgen,Eisenbiegler, Jörn,ZZZBerkling, Kay Margarethe,Li, Nuo", lecture1.getLecturer());
        Assertions.assertEquals("TINF20B5,TINF20B1,TINF21B5,TINF21B6,TINF22B4,TINF21B3,TINF20B3,TINF20B2,TINF22B6,TINF22B3,TINF20B4,TINF21B1,TINF21B4,TINF22B5,TINF22B1,TINF21B2,TINF22B2", lecture1.getRoom());
        Assertions.assertEquals("Christi Himmelfahrt", lecture1.getLecture());
        Assertions.assertEquals(LocalDateTime.of(2023, Month.MAY, 18, 8, 0), lecture1.getStart());
        Assertions.assertEquals(LocalDateTime.of(2023, Month.MAY, 18, 18, 0), lecture1.getEnd());
        Assertions.assertEquals(LocalDate.of(2023, Month.MAY, 18), lecture1.getDate());

    }
}
