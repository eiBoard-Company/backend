package dhbw.eiCompany.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dhbw.eiCompany.dto.EventDTO;
import dhbw.eiCompany.dto.PersonCreateDTO;
import dhbw.eiCompany.dto.PersonDTO;
import dhbw.eiCompany.dto.TaskDTO;
import dhbw.eiCompany.model.Event;
import dhbw.eiCompany.model.Person;
import dhbw.eiCompany.model.Task;

@Component
public class PersonMapper {
	
	@Autowired
	BlobMapper blobMapper;
	
	@Autowired
	TaskMapper taskMapper;
	
	@Autowired
	EventMapper eventMapper;
	
	public Person personDTOtoPerson(PersonDTO dto) {
		if(dto == null) {
			return null;
		}
		Person p = new Person();
		p.setUserId(dto.getId());
		p.setEmail(dto.getEmail());
		p.setFirstName(dto.getFirstName());
		p.setLastName(dto.getLastName());
		p.setPicture(blobMapper.mapBlob(dto.getPicture()));
		p.setRaplaLink(dto.getRaplaLink());
		p.setTasks(taskDTOtoTaskList(dto.getTaks()));
		p.setEvents(eventDTOtoEventList(dto.getEvents()));
		return p;
	}
	
	private List<Task> taskDTOtoTaskList(List<TaskDTO> listToConvert) {
	
			if(listToConvert == null) {
				return null;
			}
			
			List<Task> tList = new ArrayList<>();
			for(TaskDTO task : listToConvert) {
				tList.add(taskMapper.taskDTOtoTask(task));
			}
			return tList;
	}
	
	private List<Event> eventDTOtoEventList(List<EventDTO> listToConvert) {
		
		if(listToConvert == null) {
			return null;
		}
		
		List<Event> tList = new ArrayList<>();
		for(EventDTO event : listToConvert) {
			tList.add(eventMapper.eventDTOtoEvent(event));
		}
		return tList;
	}
	
	private List<TaskDTO> tasktoTaskDTOList(List<Task> listToConvert) {
		
		if(listToConvert == null) {
			return null;
		}
		
		List<TaskDTO> tList = new ArrayList<>();
		for(Task task : listToConvert) {
			tList.add(taskMapper.taskToTaskDTO(task));
		}
		return tList;
	}

	private List<EventDTO> eventtoEventDTOList(List<Event> listToConvert) {
		
		if(listToConvert == null) {
			return null;
		}
		
		List<EventDTO> tList = new ArrayList<>();
		for(Event event : listToConvert) {
			tList.add(eventMapper.eventToEventDTO(event));
		}
		return tList;
	}
	
	public PersonDTO personToPersonDTO(Person person) {
		if(person == null) {
			return null;
		}
		
		PersonDTO dto = new PersonDTO();
		dto.setId(person.getUserId());
		dto.setEmail(person.getEmail());
		dto.setFirstName(person.getFirstName());
		dto.setLastName(person.getLastName());
		dto.setPicture(blobMapper.mapBlob(person.getPicture()));
		dto.setRaplaLink(person.getRaplaLink());
		dto.setTaks(tasktoTaskDTOList(person.getTasks()));
		dto.setEvents(eventtoEventDTOList(person.getEvents()));
		return dto;
	}
	
	public Person personCreateDTOToPerson(PersonCreateDTO dto) {
		if(dto == null) {
			return null;
		}
		Person p = new Person();
		p.setEmail(dto.getEmail());
		p.setFirstName(dto.getFirstName());
		p.setLastName(dto.getLastName());
		p.setPassword(dto.getPassword());
		return p;
	}
	
	public PersonCreateDTO personToPersonCreateDTO(Person p) {
		if(p == null) {
			return null;
		}
		PersonCreateDTO dto = new PersonCreateDTO();
		dto.setEmail(p.getEmail());
		dto.setFirstName(p.getFirstName());
		dto.setLastName(p.getLastName());
		dto.setPassword(p.getPassword());
		return dto;
	}
}
