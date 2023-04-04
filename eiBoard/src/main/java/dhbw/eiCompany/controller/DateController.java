package dhbw.eiCompany.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dhbw.eiCompany.service.LectureService;
import dhbw.eiCompany.timetable.ScheduleDay;

@RestController
public class DateController {

	@Autowired
	private LectureService lectureService;
	
    @GetMapping(path = "/lectures/{date}/day")
    public @ResponseBody ScheduleDay scheduleDay(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
    	return lectureService.getDay(date);
    }
    
   /**	
    *
    * @param ein Tag der Woche, egal welcher
    * @return Gibt eine ganze Woche als Liste zurück
    */
     @GetMapping(path = "/lectures/{date}/week")
    public @ResponseBody List<ScheduleDay> scheduleWeekFriday(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
    	return lectureService.getWeek(date);
    }
     
    
}
