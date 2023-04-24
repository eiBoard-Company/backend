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

import dhbw.eiCompany.model.Entry;
import dhbw.eiCompany.service.EntryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
public class EntryController {

    @Autowired
    EntryService entryService;

    @Tag(name = "Entry")
	@Operation(summary = "Create a Entry", description = "Create a new Entry")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Returns created Entry", content = @Content(schema = @Schema(implementation = Entry.class))),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Unauthorized", content = @Content()),
			@ApiResponse(responseCode = "406", description = "Wrong Input")})
    @PostMapping(path = "/entry")
    private ResponseEntity<Entry> saveEntry(@RequestBody Entry entry){
       entry = entryService.save(entry);
       if(entry == null) {
    	   return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
       }
        return new ResponseEntity<>(entry, HttpStatus.CREATED);
    }
    @Tag(name = "Entry")
	@Operation(summary = "Delete a Entry", description = "Delete a Entry with a specific Entry ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Returns deleted Entry", content = @Content(schema = @Schema(implementation = Entry.class))),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Unauthorized", content = @Content()),
			@ApiResponse(responseCode = "404", description = "Wrong ID")})
    @DeleteMapping(path = "/entry/{id}")
    private ResponseEntity<Entry> deleteEntry(@PathVariable("id") Long entryId){
    	Entry e = entryService.findById(entryId);
    	if(entryId == null || e == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
        entryService.delete(entryId);
        return new ResponseEntity<>(e,HttpStatus.OK);
    }
    @Tag(name = "Entry")
	@Operation(summary = "Find a Entry", description = "Find a specific Entry by its Entry ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Return found Entry", content = @Content(schema = @Schema(implementation = Entry.class))),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Unauthorized", content = @Content()),
			@ApiResponse(responseCode = "404", description = "No Entry found by ID")})
    @GetMapping(path = "/entry/{id}")
    private ResponseEntity<Entry> findById(@PathVariable("id") Long entryId){
    	Entry e = entryService.findById(entryId);
    	if(e == null || entryId == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
        return new ResponseEntity<>(entryService.findById(entryId), HttpStatus.OK);
    }
    @Tag(name = "Entry")
	@Operation(summary = "Get all Entries", description = "List all Entrys existing")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "List Entries", content = @Content(schema = @Schema(implementation = Entry.class))),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Unauthorized", content = @Content())})
    @GetMapping(path = "/entries")
    private ResponseEntity<List<Entry>> getAllEntries(){
        return new ResponseEntity<>(entryService.getAllEntries(), HttpStatus.OK);
    }


}
