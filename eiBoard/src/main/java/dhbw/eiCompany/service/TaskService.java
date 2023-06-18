package dhbw.eiCompany.service;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dhbw.eiCompany.dto.TaskDTO;
import dhbw.eiCompany.mapper.TaskMapper;
import dhbw.eiCompany.model.Person;
import dhbw.eiCompany.model.Task;
import dhbw.eiCompany.repositories.TaskRepository;

@Service
public class TaskService {

	
	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	TaskMapper taskMapper;
	
	
	public List<Task> findAll() {
		return taskRepository.findAll();
	}
	
    public Task saveOrUpdate(Task t){
        return taskRepository.save(t);
     }
    
	public Task findById(Long id) {
		return taskRepository.findById(id).get();
	}
	
	public void deleteById(Long id) {
		taskRepository.deleteById(id);
	}
	
	public void deleteByTask(Task task) {
		 taskRepository.delete(task);
	}
	
	public Task updateTask(Task updatedTask) {
		Task allData = findById(updatedTask.getId());
    	if(updatedTask.getCategory() == null) {
    		updatedTask.setCategory(allData.getCategory());
    	}if(updatedTask.getDescription() == null) {
    		updatedTask.setDescription(allData.getDescription());
    	} if(updatedTask.getEndDate() == null) {
    		updatedTask.setEndDate(allData.getEndDate());
    	} if(updatedTask.getProgress() == 0) {
    		updatedTask.setProgress(allData.getProgress());
    	} if(updatedTask.getTitel() == null) {
    		updatedTask.setTitel(allData.getTitel());
    	}if(updatedTask.getStatus() == null) {
    		updatedTask.setStatus(allData.getStatus());
    	}
    	taskRepository.updateTask(updatedTask.getTitel(), updatedTask.getDescription(), updatedTask.getEndDate(), updatedTask.getStatus(), updatedTask.getProgress(), updatedTask.getCategory(), updatedTask.getId());
		return findById(updatedTask.getId());
	}
	
	public String updatedStatus(Long id) {
		Task t = findById(id);
		if(t.getStatus().equalsIgnoreCase("done")) {
			t.setStatus("Not done");
		} else {
			t.setStatus("Done");
		}
		Task updatedTask = updateTask(t);
		return updatedTask.getStatus();
		
	}
	
	public double addProgress(Long id, double percentToAdd) {
		Task t = findById(id);
		double addedPercent = t.getProgress() + percentToAdd;
		if(addedPercent > 100) {
			// TODO: Throw error
			return 0;
		} else {
			t.setProgress(addedPercent);
			updateTask(t);
			return addedPercent;
		}
		
	}
	
	public double setProgress(Long id, double percentToSet) {
		Task t = findById(id);
		if(percentToSet > 100) {
			// TODO: Throw error
			return 0;
		} else {
			t.setProgress(percentToSet);
			updateTask(t);
			return percentToSet;
		}
		
	}
	
	public ResponseEntity<TaskDTO> updateDue(Long id) {
		if(findById(id) == null) {
			return new ResponseEntity<TaskDTO>(HttpStatus.NOT_FOUND);
		}
		Task t = findById(id);
		LocalDateTime endDate = t.getEndDate();
		LocalDateTime currentDate = LocalDateTime.now();
		
		//Overdue, das aktuelle Datum ist später als das End Datum
		if(currentDate.isAfter(endDate)) {
			return checkAndDoChanges(t, Categories.OVERDUE);
		}
		
		//Schauen ob das Datum übereinstimmt => gleicher Tag = > due this day
		if(endDate.getDayOfMonth() == currentDate.getDayOfMonth() &&
			   endDate.getMonth() == currentDate.getMonth() &&
			   endDate.getYear() == currentDate.getYear()) {
			return checkAndDoChanges(t, Categories.TODAY);
		}
		
		// Vergleiche ob die Woche die gleiche ist und das aktuelle datum aber vor dem end Datum ist => due this week
		int currentWeekNumber = currentDate.get(WeekFields.ISO.weekBasedYear());
		int endWeekNumber = currentDate.get(WeekFields.ISO.weekBasedYear());
		if(endDate.getMonth() == currentDate.getMonth() &&
				currentDate.isBefore(endDate) &&
				currentWeekNumber == endWeekNumber &&
				endDate.getYear() == currentDate.getYear()) {
			return checkAndDoChanges(t, Categories.THISWEEK);
		}
		
		//Ansonsten: EndDate liegt noch lange in der Zukunft
		return checkAndDoChanges(t, Categories.DUEINFUTURE);
	}
	
	private ResponseEntity<TaskDTO> checkAndDoChanges(Task t, Categories c) {
		if(t.getCategory().equalsIgnoreCase(c.getCategorieString())) {
			// Es muss nichts geupdated werden, der Task ist schon auf aktuellem Stand
			return new ResponseEntity<TaskDTO>(HttpStatus.ALREADY_REPORTED);
		} else {
			t.setCategory(c.getCategorieString());
			t = saveOrUpdate(t);
			return new ResponseEntity<TaskDTO>(taskMapper.taskToTaskDTO(t), HttpStatus.OK);
		}
	}
	
	public enum Categories {
		TODAY("Due this day"),
		THISWEEK("Due this week"),
		OVERDUE("Overdue"),
		DUEINFUTURE("Due in future");
		
		private String s;
		
		private Categories(String s) {
			this.s = s;
		}
		
		public String getCategorieString() {
			return s;
		}
	}
}
