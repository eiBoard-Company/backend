package dhbw.eiCompany.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dhbw.eiCompany.dto.EventDTO;
import dhbw.eiCompany.dto.TaskDTO;
import dhbw.eiCompany.model.Person;
import dhbw.eiCompany.model.Task;
@Component
public class TaskMapper {
	@Autowired
	PersonMapper personMapper;
	
	
	
	public Task taskDTOtoTask(TaskDTO dto) {
		if(dto == null) {
			return null;
		}
		Task e = new Task();
		e.setId(dto.getId());
		e.setDescription(dto.getDescription());
		e.setCategory(dto.getCategory());
		e.setEndDate(dto.getEndDate());
		e.setTitel(dto.getTitel());
		e.setProgress(dto.getProgress());
		e.setStatus(dto.getStatus());
		return e;
	}
	
	public TaskDTO taskToTaskDTO(Task e) {
		
		if(e == null) {
			return null;
		}
		TaskDTO dto = new TaskDTO();
		dto.setId(e.getId());
		dto.setDescription(e.getDescription());
		dto.setCategory(e.getCategory());
		dto.setPersonId(e.getPerson().getUserId());
		dto.setEndDate(e.getEndDate());
		dto.setTitel(e.getTitel());
		dto.setProgress(e.getProgress());
		dto.setStatus(e.getStatus());
		return dto;
		
		
		
	}
}
