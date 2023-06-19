package dhbw.eiCompany.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dhbw.eiCompany.dto.EventDTO;
import dhbw.eiCompany.mapper.EventMapper;
import dhbw.eiCompany.model.Event;
import dhbw.eiCompany.model.Person;
import dhbw.eiCompany.service.EventService;
import dhbw.eiCompany.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
@CrossOrigin(origins = "http://eiBoard.de", maxAge = 3600)
@RestController
public class EventController {

	@Autowired
	EventService eventService;
	
	@Autowired
	EventMapper eventMapper;
	
	@Autowired
	PersonService personService;
	
    @Tag(name = "Event")
	@Operation(summary = "Get an Event", description = "Get a specific Event by its ID")
    @PreAuthorize("hasRole('ROLE_USER')")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Returns task", content = @Content(schema = @Schema(implementation = EventDTO.class))),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Unauthorized", content = @Content()),
			@ApiResponse(responseCode = "404", description = "No Event found by ID")})
    @GetMapping(path ="/event/{id}")
    public ResponseEntity<EventDTO> events(@PathVariable Long id){
    	Event event = eventService.findById(id);
    	if(event == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    	
        return new ResponseEntity<>(eventMapper.eventToEventDTO(event), HttpStatus.OK);
    }
    
    @Tag(name = "Event")
    @PreAuthorize("hasRole('ROLE_USER')")
   	@Operation(summary = "Get all Events", description = "Get all existing event")
   	@ApiResponses(value = {
   			@ApiResponse(responseCode = "200", description = "Returns events", content = @Content(schema = @Schema(implementation = EventDTO.class))),
   			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content()),
   			@ApiResponse(responseCode = "403", description = "Unauthorized", content = @Content()),
   			@ApiResponse(responseCode = "404", description = "No Event found by ID")})
       @GetMapping(path ="/event")
       public ResponseEntity<List<EventDTO>> events(){
       	List<Event> event = eventService.findAll();
       	if(event == null) {
       		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       	}
       	List<EventDTO> dto = new ArrayList<>();
       	for(Event e : event) {
       		dto.add(eventMapper.eventToEventDTO(e));
       	}
           return new ResponseEntity<>(dto, HttpStatus.OK);
       }
    
    @Tag(name = "Event")
    @PreAuthorize("hasRole('ROLE_USER')")
   	@Operation(summary = "create an Event", description = "create a task with given Event infos")
   	@ApiResponses(value = {
   			@ApiResponse(responseCode = "201", description = "Event successfully created", content = @Content(schema = @Schema(implementation = EventDTO.class))),
   			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content()),
   			@ApiResponse(responseCode = "403", description = "Unauthorized", content = @Content())})
       @PostMapping(path ="/Event")
       public ResponseEntity<EventDTO> createEvent(@RequestBody EventDTO event){
    	System.out.println(event.getTitel() + " " + event.getPersonId());
    	Person p = personService.findById(event.getPersonId());
    	if(p == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    	Event e = eventMapper.eventDTOtoEvent(event);
    	e.setPerson(p);
    	e = eventService.createEvent(e);
       	if(e == null) {
       		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       	}
       	
           return new ResponseEntity<>(event, HttpStatus.CREATED);
       }
    
    @Tag(name = "Event")
    @PreAuthorize("hasRole('ROLE_USER')")
   	@Operation(summary = "update a Event", description = "Update an existing Event with given Event infos")
   	@ApiResponses(value = {
   			@ApiResponse(responseCode = "200", description = "Event successfully updated", content = @Content(schema = @Schema(implementation = EventDTO.class))),
   			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content()),
   			@ApiResponse(responseCode = "403", description = "Unauthorized", content = @Content())})
       @PutMapping(path ="/Event")
       public ResponseEntity<EventDTO> updateEvents(@RequestBody EventDTO event){
    	
    	if(event.getId() == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    	}
    	if(eventService.findById(event.getId()) == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    	Event e = eventMapper.eventDTOtoEvent(event);
    	
    	Person p = personService.findById(event.getPersonId());
    	if(p == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    	}
    	e.setPerson(p);
    	e = eventService.updateEvent(e);
       	if(e == null) {
       	   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       	}
           return new ResponseEntity<>(eventMapper.eventToEventDTO(e), HttpStatus.CREATED);
       }
}
