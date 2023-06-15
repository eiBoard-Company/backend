package dhbw.eiCompany.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskDTO {
		private Long id;
		private String titel;
		private LocalDateTime endDate;
		private String status;
		private int progress;
		private String category;
		private Long personId;
		private String description;
		
		public TaskDTO() {
			
		}
		
		public TaskDTO(Long id, String titel,  LocalDateTime endDate, String status, int progress,
				String category, Long personId, String description) {
			super();
			this.id = id;
			this.titel = titel;
			this.endDate = endDate;
			this.status = status;
			this.progress = progress;
			this.category = category;
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
		public String getTitel() {
			return titel;
		}
		public void setTitel(String titel) {
			this.titel = titel;
		}

		public LocalDateTime getEndDate() {
			return endDate;
		}
		public void setEndDate(LocalDateTime endDate) {
			this.endDate = endDate;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public int getProgress() {
			return progress;
		}
		public void setProgress(int progress) {
			this.progress = progress;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
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
