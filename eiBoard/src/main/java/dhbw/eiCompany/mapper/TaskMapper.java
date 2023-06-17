package dhbw.eiCompany.mapper;

import java.time.LocalDateTime;

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
		e.setCategory(dto.getDueValue());
		e.setEndDate(dto.getTime());
		e.setTitel(dto.getTaskname());
		e.setProgress(dto.getCompleteValue());
		e.setStatus(dto.getSubject());
		return e;
	}
	
	public TaskDTO taskToTaskDTO(Task e) {
		
		if(e == null) {
			return null;
		}
		TaskDTO dto = new TaskDTO();
		dto.setId(e.getId());
		dto.setDescription(e.getDescription());
		dto.setDueValue(e.getCategory());;
		dto.setPersonId(e.getPerson().getUserId());
		dto.setTime(e.getEndDate());
		dto.setTaskname(e.getTitel());
		dto.setCompleteValue(e.getProgress());
		dto.setSubject(e.getStatus());
		return dto;
		
		
		
	}
}
