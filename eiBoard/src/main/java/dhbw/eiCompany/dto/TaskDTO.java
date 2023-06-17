package dhbw.eiCompany.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskDTO {
		private Long id;			 //typId im Frontend
		private String taskname; 	 // früher titel
		private String description;
		private LocalDateTime time;  //früher endDate
		private String subject;		 //früher: status
		private double completeValue;		 // früher progress
		private String dueValue; 	 //früher category
		private Long personId;
		
		public TaskDTO() {
			
		}
		
		public TaskDTO(Long id, String taskname,  LocalDateTime time, String subject, double completeValue,
				String dueValue, Long personId, String description) {
			super();
			this.id = id;
			this.taskname = taskname;
			this.time = time;
			this.subject = subject;
			this.completeValue = completeValue;
			this.dueValue = dueValue;
			this.personId = personId;
			this.description = description;
		}
		@JsonProperty
		public Long getId() {
			return id;
		}
		
		@JsonIgnore
		public void setId(Long id) {
			this.id = id;
		}
		public String getTaskname() {
			return taskname;
		}
		public void setTaskname(String taskname) {
			this.taskname = taskname;
		}

		public LocalDateTime getTime() {
			return time;
		}
		public void setTime(LocalDateTime time) {
			this.time = time;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public double getCompleteValue() {
			return completeValue;
		}
		public void setCompleteValue(double completeValue) {
			this.completeValue = completeValue;
		}
		public String getDueValue() {
			return dueValue;
		}
		public void setDueValue(String dueValue) {
			this.dueValue = dueValue;
		}


		public String getDescription() {
			return description;
		}


		public Long getPersonId() {
			return personId;
		}


		public void setPersonId(Long personId) {
			this.personId = personId;
		}


		public void setDescription(String description) {
			this.description = description;
		}
		
		
}
