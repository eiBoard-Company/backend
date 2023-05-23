package dhbw.eiCompany.integrationTests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import dhbw.eiCompany.timetable.Lecture;
import dhbw.eiCompany.timetable.ScheduleDay;

@SpringBootTest
@AutoConfigureMockMvc
public class DateIntegrationTest {

	@Autowired
	private MockMvc mock;

	private ObjectMapper mapper = new ObjectMapper();
	
	@Test
	 void testLectureByDay() throws Exception {
		ScheduleDay day = new ScheduleDay();
		Lecture lec1 = new Lecture("Rotzinger, Frank", "F492  Hörsaal,TINF21B4", "Statistik",
				LocalDateTime.of(2023, 4, 4, 9, 0, 0), LocalDateTime.of(2023, 4, 4, 12, 15, 0),
				LocalDate.of(2023, 4, 4));
		
		Lecture lec2 = new Lecture("Senger, Markus", "F492  Hörsaal,TINF21B4", "Grundlagen der Datenbanken",
				LocalDateTime.of(2023, 4, 4, 13, 0, 0), LocalDateTime.of(2023, 4, 4, 16, 15, 0),
				LocalDate.of(2023, 4, 4));
		
		Lecture lec3 = new Lecture("Klages, Henner", "TINF21B5,TINF21B2,A267  Hörsaal,TINF21B4", "AdA (Z)",
				LocalDateTime.of(2023, 4, 4, 16, 30, 0), LocalDateTime.of(2023, 4, 4, 19, 0, 0),
				LocalDate.of(2023, 4, 4));
		
		day.addLecture(lec1);
		day.addLecture(lec2);
		day.addLecture(lec3);
		mapper.registerModule(new JavaTimeModule());
		
		MvcResult result = this.mock.perform(get("/lectures/2023-04-04/day")).andDo(print()).andExpect(status().isOk()).andReturn();
		ScheduleDay sd = mapper.readValue(result.getResponse().getContentAsString(StandardCharsets.UTF_8), ScheduleDay.class);
		testLectures(day.getLectureList(), sd.getLectureList());
		
		
	}
	
	@Test
	 void testLectureByWeek() throws Exception {
		ScheduleDay day1 = new ScheduleDay();
		ScheduleDay day2 = new ScheduleDay();
		
		Lecture lec0 = new Lecture("Freudenmann, Johannes,Eisenbiegler, Jörn,Vollmer, Jürgen,Strand, Marcus", "TINF21B5,TINF21B6,TINF21B2,TINF21B1,TINF21B3,TINF21B4", "Beginn Theoriephase 4. Semester",
				LocalDateTime.of(2023, 4, 3, 7, 30, 0), LocalDateTime.of(2023, 4, 3, 8, 0, 0),
				LocalDate.of(2023, 4, 3));
		
		Lecture lec1 = new Lecture("Braun, Heinrich,Lausen, Ralph,Freudenmann, Johannes,Vollmer, Jürgen,Strand, Marcus,Röthig, Jürgen,Eisenbiegler, Jörn,ZZZBerkling, Kay Margarethe,Li, Nuo", "TINF20B5,TINF20B1,TINF21B5,TINF21B6,TINF22B4,TINF21B3,TINF20B3,TINF20B2,TINF22B6,TINF22B3,TINF20B4,TINF21B1,TINF21B4,TINF22B5,TINF22B1,TINF21B2,TINF22B2", "Karfreitag",
				LocalDateTime.of(2023, 4, 7, 8, 0, 0), LocalDateTime.of(2023, 4, 7, 18, 0, 0),
				LocalDate.of(2023, 4, 7));
		
		Lecture lec2 = new Lecture("Li, Nuo", "F492  Hörsaal,TINF21B4", "Grundlagen des Software Engineering",
				LocalDateTime.of(2023, 4, 3, 9, 0, 0), LocalDateTime.of(2023, 4, 3, 13, 0, 0),
				LocalDate.of(2023, 4, 3));
		
		Lecture lec3 = new Lecture("Rotzinger, Frank", "F492  Hörsaal,TINF21B4", "Statistik",
				LocalDateTime.of(2023, 4, 4, 9, 0, 0), LocalDateTime.of(2023, 4, 4, 12, 15, 0),
				LocalDate.of(2023, 4, 4));
		
		Lecture lec4 = new Lecture("Eisenbiegler, Jörn", "F492  Hörsaal,TINF21B4", "Compilerbau",
				LocalDateTime.of(2023, 4, 5, 9, 0, 0), LocalDateTime.of(2023, 4, 5, 12, 15, 0),
				LocalDate.of(2023, 4, 5));
		
		Lecture lec5 = new Lecture("Eisenbiegler, Jörnk", "F492  Hörsaal,TINF21B4", "Compilerbau",
				LocalDateTime.of(2023, 4, 6, 9, 0, 0), LocalDateTime.of(2023, 4, 6, 12, 15, 0),
				LocalDate.of(2023, 4, 6));
		
		Lecture lec6 = new Lecture("Senger, Markus", "F492  Hörsaal,TINF21B4", "Grundlagen der Datenbanken",
				LocalDateTime.of(2023, 4, 4, 13, 0, 0), LocalDateTime.of(2023, 4, 4, 16, 15, 0),
				LocalDate.of(2023, 4, 4));
		
		Lecture lec7 = new Lecture("Lausen, Ralph", "F492  Hörsaal,TINF21B4", "Systemnahe Programmierung I",
				LocalDateTime.of(2023, 4, 6, 13, 15, 0), LocalDateTime.of(2023, 4, 6, 16, 15, 0),
				LocalDate.of(2023, 4, 6));
		
		Lecture lec8 = new Lecture("Klages, Henner", "TINF21B5,TINF21B2,A267  Hörsaal,TINF21B4", "AdA (Z)",
				LocalDateTime.of(2023, 4, 4, 16, 30, 0), LocalDateTime.of(2023, 4, 4, 19, 0, 0),
				LocalDate.of(2023, 4, 4));
//		
//		day.addLecture(lec0);
//		day.addLecture(lec1);
//		day.addLecture(lec2);
//		day.addLecture(lec3);
//		day.addLecture(lec4);
//		day.addLecture(lec5);
//		day.addLecture(lec6);
//		day.addLecture(lec7);
//		day.addLecture(lec8);
		
		mapper.registerModule(new JavaTimeModule());
		
		MvcResult result = this.mock.perform(get("/lectures/2023-04-04/week")).andDo(print()).andExpect(status().isOk()).andReturn();
		System.out.println(result.getResponse().getContentAsString(StandardCharsets.UTF_8));
		ScheduleDay sd = mapper.readValue(result.getResponse().getContentAsString(StandardCharsets.UTF_8), ScheduleDay.class);
	//	testLectures(day.getLectureList(), sd.getLectureList());
		
		
	}
	
	private void testLectures(List<Lecture> expected, List<Lecture> actual) {
		assertEquals(expected.size(), actual.size());
		for(int i= 0; i < expected.size(); i++) {
			assertEquals(expected.get(i).getLecture(), actual.get(i).getLecture());
			assertEquals(expected.get(i).getDate(), actual.get(i).getDate());
			assertEquals(expected.get(i).getEnd(), actual.get(i).getEnd());
			assertEquals(expected.get(i).getLecturer(), actual.get(i).getLecturer());
			assertEquals(expected.get(i).getRoom(), actual.get(i).getRoom());
			assertEquals(expected.get(i).getStart(), actual.get(i).getStart());
			
		}
	}
}
