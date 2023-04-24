package dhbw.eiCompany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dhbw.eiCompany.model.Person;
import dhbw.eiCompany.service.PersonService;
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
    @Tag(name = "User")
	@Operation(summary = "Get a User", description = "Get a specific user by his ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Returns user", content = @Content(schema = @Schema(implementation = Person.class))),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Unauthorized", content = @Content()),
			@ApiResponse(responseCode = "404", description = "No User found by ID")})
    @GetMapping(path ="/user/{id}")
    public ResponseEntity<Person> users(@PathVariable Long id){
    	Person p = personService.findById(id);
    	if(p == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    	
        return new ResponseEntity<>(personService.findById(id), HttpStatus.OK);
    }

    @Tag(name = "User")
	@Operation(summary = "List all users", description = "List all existing users")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Returns users successfully", content = @Content(schema = @Schema(implementation = Person.class))),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Unauthorized", content = @Content()),
			@ApiResponse(responseCode = "504", description = "Wrong input")})
    @GetMapping(path = "/user")
    public ResponseEntity<List<Person>> getAllUser(){
        return new ResponseEntity<>(personService.getAllUser(), HttpStatus.OK);
    }

    @Tag(name = "User")
	@Operation(summary = "Delete a User", description = "Delete a specific user by his ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Return deleted User", content = @Content(schema = @Schema(implementation = Person.class))),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Unauthorized", content = @Content()),
			@ApiResponse(responseCode = "404", description = "No User found by ID")})
    @DeleteMapping("/user/{id}")
    private ResponseEntity<Person> deleteUser(@PathVariable("id") Long id){
    	Person p = personService.findById(id);
    	if(id == null || p == null ) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
        personService.deleteById(id);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @Tag(name = "User")
	@Operation(summary = "Create a User", description = "Create or Update an existing User with data")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Returns created user", content = @Content(schema = @Schema(implementation = Person.class))),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Unauthorized", content = @Content()),
			@ApiResponse(responseCode = "406", description = "Wrong Content")})
    @PostMapping(path="/user")
    private ResponseEntity<Person> saveUser(@RequestBody Person person){
    	person =  personService.saveOrUpdate(person);
    	if(person == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    	}
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }
}