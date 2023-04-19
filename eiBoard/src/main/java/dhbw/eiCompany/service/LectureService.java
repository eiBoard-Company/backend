package dhbw.eiCompany.service;

import java.net.MalformedURLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import dhbw.eiCompany.timetable.Lecture;
import dhbw.eiCompany.timetable.ScheduleDay;
import dhbw.timetable.rapla.data.event.Appointment;
import dhbw.timetable.rapla.exceptions.NoConnectionException;
import dhbw.timetable.rapla.parser.DataImporter;

@Service
public class LectureService {

	private String url = "https://rapla.dhbw-karlsruhe.de/rapla?page=calendar&user=eisenbiegler&file=TINF21B4";
	

	 public ScheduleDay getDay(LocalDate date) {
		 ScheduleDay day = new ScheduleDay();
	    	
				 Map<LocalDate, ArrayList<Appointment>> data = null;
				try {
					data = DataImporter.ImportWeekRange(date, date.plusDays(1), url);
					System.out.println(date);
				} catch (MalformedURLException | IllegalAccessException | NoConnectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
	    	   for(ArrayList<Appointment> value  : data.values()){
	               for(Appointment app : value){
	            	   if(!app.getStartDate().toLocalDate().equals(date)) continue;
	                   final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
	                   final LocalDate dt =  LocalDate.parse(app.getDate(), dtf);
	                   dt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	                   Lecture lecture = new Lecture(app.getPersons(), app.getResources(), app.getTitle(), app.getStartDate(), app.getEndDate(), dt );
	                   day.addLecture(lecture);
	               }
	           }
	           return day;
	    }
	    
	   
	    public List<ScheduleDay> getWeek(LocalDate date) {
	    	List<ScheduleDay> dayList = new ArrayList<>();
	    	LocalDateTime monday = date.atStartOfDay().with(TemporalAdjusters.previousOrSame( DayOfWeek.MONDAY ));
	    	Map<LocalDate, ArrayList<Appointment>> data = null;
			try {
				data = DataImporter.ImportWeekRange(monday.toLocalDate(), monday.toLocalDate(), url);
			} catch (MalformedURLException | IllegalAccessException | NoConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	   for(ArrayList<Appointment> value  : data.values()){
	    		   ScheduleDay day = new ScheduleDay();
	               for(Appointment app : value){
	                   final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
	                   final LocalDate dt =  LocalDate.parse(app.getDate(), dtf);
	                   dt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	                   Lecture lecture = new Lecture(app.getPersons(), app.getResources(), app.getTitle(), app.getStartDate(), app.getEndDate(), dt );
	                   day.addLecture(lecture);
	               }
	               dayList.add(day);
	           }
	    	   return dayList;
	    }

}
