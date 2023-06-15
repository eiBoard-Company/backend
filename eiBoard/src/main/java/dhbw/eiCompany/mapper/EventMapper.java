package dhbw.eiCompany.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dhbw.eiCompany.dto.EventDTO;
import dhbw.eiCompany.model.Event;
import dhbw.eiCompany.model.Person;

@Component
public class EventMapper {

	
	@Autowired
	PersonMapper personMapper;
	
	public Event eventDTOtoEvent(EventDTO dto) {
		if(dto == null) {
			return null;
		}
		Event e = new Event();
		e.setId(dto.getId());
		e.setDescription(dto.getDescription());
		e.setLocation(dto.getLocation());
		e.setCategory(dto.getCategory());
		e.setEndDate(dto.getEndDate());
		e.setStartDate(dto.getStartDate());
		e.setTitel(dto.getTitel());
		e.setProgress(dto.getProgress());
		return e;
	}
	
	public EventDTO eventToEventDTO(Event e) {
		
		if(e == null) {
			return null;
		}
		EventDTO dto = new EventDTO();
		dto.setId(e.getId());
		dto.setDescription(e.getDescription());
		dto.setLocation(e.getLocation());
		dto.setCategory(e.getCategory());
		dto.setPersonId(e.getPerson().getUserId());
		dto.setEndDate(e.getEndDate());
		dto.setStartDate(e.getStartDate());
		dto.setTitel(e.getTitel());
		dto.setProgress(e.getProgress());
		return dto;
	}
	
}
