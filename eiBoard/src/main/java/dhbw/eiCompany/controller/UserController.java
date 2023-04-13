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

import dhbw.eiCompany.database.Person;
import dhbw.eiCompany.interfaces.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class UserController {

    @Autowired
    PersonService personService;

    @GetMapping(path ="/user/{name}")
    public ResponseEntity<Person> users(@PathVariable String name){
        return new ResponseEntity<>(personService.findByName(name), HttpStatus.OK);
    }


	@Operation(summary = "List all users", description = "List all existing users")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Returns users successfully", content = @Content(schema = @Schema(implementation = Person.class))),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Unauthorized", content = @Content()), })
    @GetMapping(path = "/user")
    public ResponseEntity<List<Person>> getAllUser(){
        return new ResponseEntity<>(personService.getAllUser(), HttpStatus.OK);
    }

    @DeleteMapping("/user/{name}")
    private ResponseEntity<Person> deleteUser(@PathVariable("name") Person name){
        personService.delete(name);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping(path="/user")
    private ResponseEntity<Long> saveUser(@RequestBody Person name){
        personService.saveOrUpdate(name);
        return new ResponseEntity<>(name.getUserId(), HttpStatus.ACCEPTED);
    }
}