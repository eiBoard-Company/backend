package dhbw.eiCompany.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dhbw.eiCompany.dto.EventDTO;
import dhbw.eiCompany.dto.PersonCreateDTO;
import dhbw.eiCompany.dto.PersonDTO;
import dhbw.eiCompany.dto.TaskDTO;
import dhbw.eiCompany.mapper.EventMapper;
import dhbw.eiCompany.mapper.PersonMapper;
import dhbw.eiCompany.mapper.TaskMapper;
import dhbw.eiCompany.model.Event;
import dhbw.eiCompany.model.Person;
import dhbw.eiCompany.model.Task;
import dhbw.eiCompany.service.LectureService;
import dhbw.eiCompany.service.PersonService;
import dhbw.eiCompany.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
public class UserController {

    @Autowired
    PersonService personService;
    
    @Autowired
    TaskService taskService;
    
    @Autowired
    PersonMapper personMapper;
    
    @Autowired
    TaskMapper taskMapper;
    
    @Autowired
    EventMapper eventMapper;
    
    @Autowired
    LectureService lectureService;
    
    @Tag(name = "User")
	@Operation(summary = "Get a User", description = "Get a specific user by his ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Returns user", content = @Content(schema = @Schema(implementation = PersonDTO.class))),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Unauthorized", content = @Content()),
			@ApiResponse(responseCode = "404", description = "No User found by ID")})
    @GetMapping(path ="/user/{id}")
    public ResponseEntity<PersonDTO> users(@PathVariable Long id){
    	Person p = personService.findById(id);
    	if(p == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    	
        return new ResponseEntity<>(personMapper.personToPersonDTO(p), HttpStatus.OK);
    }
  
    @Tag(name = "User")
 	@Operation(summary = "Get all Tasks of a User", description = "List all existing tasks of a user")
 	@ApiResponses(value = {
 			@ApiResponse(responseCode = "200", description = "Returns tasks successfully", content = @Content(schema = @Schema(implementation = TaskDTO.class))),
 			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content()),
 			@ApiResponse(responseCode = "403", description = "Unauthorized", content = @Content()),
 			@ApiResponse(responseCode = "404", description = "No User found by ID")})
     @GetMapping(path = "/user/{id}/tasks")
    public ResponseEntity<List<TaskDTO>> getTasksFromUser(@PathVariable Long id) {
    	Person p = personService.findById(id);
    	if(p == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    	List<TaskDTO> tasksDTO = new ArrayList<>();
    	for(Task t : p.getTasks()) {
    		tasksDTO.add(taskMapper.taskToTaskDTO(t));
    	}
    	return new ResponseEntity<>(tasksDTO, HttpStatus.OK);
    }
    
    @Tag(name = "User")
  	@Operation(summary = "Get all Events of a User", description = "List all existing Events of a user")
  	@ApiResponses(value = {
  			@ApiResponse(responseCode = "200", description = "Returns Events successfully", content = @Content(schema = @Schema(implementation = EventDTO.class))),
  			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content()),
  			@ApiResponse(responseCode = "403", description = "Unauthorized", content = @Content()),
  			@ApiResponse(responseCode = "404", description = "No User found by ID")})
      @GetMapping(path = "/user/{id}/events")
    public ResponseEntity<List<EventDTO>> getEventsFromUser(@PathVariable Long id) {
    	Person p = personService.findById(id);
    	if(p == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    	List<EventDTO> eventDTO = new ArrayList<>();
    	for(Event t : p.getEvents()) {
    		eventDTO.add(eventMapper.eventToEventDTO(t));
    	}
    	return new ResponseEntity<>(eventDTO, HttpStatus.OK);
    }

    @Tag(name = "User")
	@Operation(summary = "List all users", description = "List all existing users")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Returns users successfully", content = @Content(schema = @Schema(implementation = PersonDTO.class))),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Unauthorized", content = @Content()),
			@ApiResponse(responseCode = "504", description = "Wrong input")})
    @GetMapping(path = "/user")
    public ResponseEntity<List<PersonDTO>> getAllUser(){
    	List<PersonDTO> personDTO = new ArrayList<>();
    	for(Person t : personService.getAllUser()) {
    		personDTO.add(personMapper.personToPersonDTO(t));
    	}
        return new ResponseEntity<>(personDTO, HttpStatus.OK);
    }

    @Tag(name = "User")
	@Operation(summary = "Delete a User", description = "Delete a specific user by his ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Return deleted User", content = @Content(schema = @Schema(implementation = PersonDTO.class))),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Unauthorized", content = @Content()),
			@ApiResponse(responseCode = "404", description = "No User found by ID")})
    @DeleteMapping("/user/{id}")
    private ResponseEntity<PersonDTO> deleteUser(@PathVariable("id") Long id){
    	Person p = personService.findById(id);
    	if(id == null || p == null ) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
        personService.deleteById(id);
        return new ResponseEntity<>(personMapper.personToPersonDTO(p), HttpStatus.OK);
    }

    @Tag(name = "User")
	@Operation(summary = "Create a User", description = "Create  an existing User with data")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Returns created user", content = @Content(schema = @Schema(implementation = PersonDTO.class))),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Unauthorized", content = @Content()),
			@ApiResponse(responseCode = "406", description = "Wrong Content")})
    @PostMapping(path="/user")
    private ResponseEntity<PersonDTO> saveUser(@RequestBody PersonCreateDTO dto){
    	Person p = personMapper.personCreateDTOToPerson(dto);
    	p.setRaplaLink(lectureService.url);
    	p =  personService.saveOrUpdate(p);
    	if(p == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    	}
        return new ResponseEntity<>(personMapper.personToPersonDTO(p), HttpStatus.CREATED);
    }
    
    @Tag(name = "User")
	@Operation(summary = "Update an existing User", description = "Update  an existing User with data")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Returns created user", content = @Content(schema = @Schema(implementation = PersonDTO.class))),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Unauthorized", content = @Content()),
			@ApiResponse(responseCode = "406", description = "Wrong Content")})
    @PutMapping(path="/user")
    private ResponseEntity<PersonDTO> updateUser(@RequestBody PersonDTO person){
    	if(person.getId() == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    	}
    	if(personService.findById(person.getId()) == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    	Person p =  personService.saveOrUpdate(personMapper.personDTOtoPerson(person));
    	if(p == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    	}
        return new ResponseEntity<>(personMapper.personToPersonDTO(p), HttpStatus.OK);
    }
    
    @Tag(name = "User")
	@Operation(summary = "Update all Categories", description = "Update all Categories of an existing User")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "Update Successfull", content = @Content(schema = @Schema(implementation = Boolean.class))),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Unauthorized", content = @Content()),
			@ApiResponse(responseCode = "404", description = "User not found")})
    @PutMapping(path="/user/{id}/categories")
    private ResponseEntity<Boolean> updateUserCategories(@PathVariable Long id) {
    	if(personService.findById(id) == null) {
    		return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    	}
    	Person p = personService.findById(id);
    	for(Task t : p.getTasks()) {
    		taskService.updateDue(t.getId());
    	}
    	return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
    }
}