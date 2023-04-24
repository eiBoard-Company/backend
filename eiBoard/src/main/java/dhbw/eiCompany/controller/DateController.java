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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
public class DateController {

	@Autowired
	private LectureService lectureService;
	
    @GetMapping(path = "/lectures/{date}/day")
    @Tag(name = "Lectures")
	@Operation(summary = "Find a Lecture by a given date", description = "The Date has to be in the accepted ISO Format: yyyy-MM-dd it will return only one day")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Returns Lectures of the given day", content = @Content(schema = @Schema(implementation = ScheduleDay.class))),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Unauthorized", content = @Content()),
			@ApiResponse(responseCode = "406", description = "Wrong Date Format")})

    public @ResponseBody ScheduleDay scheduleDay(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
    	return lectureService.getDay(date);
    }
    
   /**	
    *
    * @param ein Tag der Woche, egal welcher
    * @return Gibt eine ganze Woche als Liste zurück
    */
     @GetMapping(path = "/lectures/{date}/week")
     @Tag(name = "Lectures")
 	@Operation(summary = "Find a Lecture by a given date", description = "The Date has to be in the accepted ISO Format: yyyy-MM-dd it will return the entire week")
 	@ApiResponses(value = {
 			@ApiResponse(responseCode = "200", description = "Returns Lectures of a week by a given day", content = @Content(schema = @Schema(implementation = ScheduleDay.class))),
 			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content()),
 			@ApiResponse(responseCode = "403", description = "Unauthorized", content = @Content()),
 			@ApiResponse(responseCode = "406", description = "Wrong Date Format")})

    public @ResponseBody List<ScheduleDay> scheduleWeekFriday(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
    	return lectureService.getWeek(date);
    }
     
    
}
