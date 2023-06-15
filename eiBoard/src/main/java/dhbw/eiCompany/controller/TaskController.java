package dhbw.eiCompany.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dhbw.eiCompany.dto.TaskDTO;
import dhbw.eiCompany.mapper.TaskMapper;
import dhbw.eiCompany.model.Person;
import dhbw.eiCompany.model.Task;
import dhbw.eiCompany.service.PersonService;
import dhbw.eiCompany.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
public class TaskController {

	@Autowired
	TaskService taskService;
	
	@Autowired
	PersonService personService;
	
	@Autowired
	TaskMapper taskMapper;
	
    @Tag(name = "Task")
	@Operation(summary = "Get a Task", description = "Get a specific task by its ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Returns task", content = @Content(schema = @Schema(implementation = TaskDTO.class))),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content()),
			@ApiResponse(responseCode = "403", description = "Unauthorized", content = @Content()),
			@ApiResponse(responseCode = "404", description = "No Task found by ID")})
    @GetMapping(path ="/task/{id}")
    public ResponseEntity<TaskDTO> tasks(@PathVariable Long id){
    	Task task = taskService.findById(id);
    	if(task == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    	
        return new ResponseEntity<>(taskMapper.taskToTaskDTO(task), HttpStatus.OK);
    }
    
    @Tag(name = "Task")
   	@Operation(summary = "Get all Tasks", description = "Get all existing tasks")
   	@ApiResponses(value = {
   			@ApiResponse(responseCode = "200", description = "Returns tasks", content = @Content(schema = @Schema(implementation = TaskDTO.class))),
   			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content()),
   			@ApiResponse(responseCode = "403", description = "Unauthorized", content = @Content()),
   			@ApiResponse(responseCode = "404", description = "No Task found by ID")})
       @GetMapping(path ="/task")
       public ResponseEntity<List<TaskDTO>> tasks(){
       	List<Task> task = taskService.findAll();
       	if(task == null) {
       		return new ResponseEntity<>(HttpStatus.OK);
       	}
       	List<TaskDTO> taskList = new ArrayList<>();
       	for(Task t : task) {
       		taskList.add(taskMapper.taskToTaskDTO(t));
       	}
           return new ResponseEntity<>(taskList, HttpStatus.OK);
       }
    
    @Tag(name = "Task")
   	@Operation(summary = "create a Task", description = "create a task with given task infos")
   	@ApiResponses(value = {
   			@ApiResponse(responseCode = "201", description = "task successfully created", content = @Content(schema = @Schema(implementation = TaskDTO.class))),
   			@ApiResponse(responseCode = "400", description = "Error while parsing given TaskDTO", content = @Content()),
   			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content()),
   			@ApiResponse(responseCode = "403", description = "Unauthorized", content = @Content())})
       @PostMapping(path ="/task")
       public ResponseEntity<TaskDTO> createTasks(@RequestBody TaskDTO dto){
    	if(dto == null) {
    	   return new ResponseEntity<TaskDTO>(HttpStatus.BAD_REQUEST);
    	}
    	Task t = taskMapper.taskDTOtoTask(dto);
    	Person p = personService.findById(dto.getPersonId());
    	if(p == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    	t.setPerson(p);
    	t = taskService.saveOrUpdate(t);
       	if(t == null) {
       	   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       	}
           return new ResponseEntity<>(taskMapper.taskToTaskDTO(t), HttpStatus.CREATED);
       }
    
    @Tag(name = "Task")
   	@Operation(summary = "update a Task", description = "Update an existing task with given task infos")
   	@ApiResponses(value = {
   			@ApiResponse(responseCode = "406", description = "TaskDTO has no ID, can't update (maybe try creating one?)", content = @Content()),
   			@ApiResponse(responseCode = "200", description = "task successfully updated", content = @Content(schema = @Schema(implementation = TaskDTO.class))),
   			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content()),
   			@ApiResponse(responseCode = "404", description = "No Task found with the same ID, can't update", content = @Content()),
   			@ApiResponse(responseCode = "409", description = "An error occured when updating the Task", content = @Content()),
   			@ApiResponse(responseCode = "403", description = "Unauthorized", content = @Content())})
       @PutMapping(path ="/task")
       public ResponseEntity<TaskDTO> updateTasks(@RequestBody TaskDTO dto){
    	
    	if(dto.getId() == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    	}
    	if(taskService.findById(dto.getId()) == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    	Task t = taskMapper.taskDTOtoTask(dto);
    	Person p = personService.findById(dto.getPersonId());
    	if(p == null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    	t.setPerson(p);
    	t = taskService.saveOrUpdate(t);
       	if(t == null) {
       		return new ResponseEntity<>(HttpStatus.CONFLICT);
       	}
           return new ResponseEntity<>(taskMapper.taskToTaskDTO(t), HttpStatus.CREATED);
       }
    
    @Tag(name = "Task")
    @Operation(summary = "Check for due Updates", description = "Updates the due Status if needed")
    @ApiResponses(value = {
    		@ApiResponse(responseCode="")
    		
    })
    @PutMapping(path = "/task/{id}")
    public ResponseEntity<TaskDTO> updateDue(@PathVariable Long id) {
    	return taskService.updateDue(id);
    }
}
