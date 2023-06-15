package dhbw.eiCompany.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EventDTO {

	private Long id;
	private String description;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private String location;
	private int progress;
	private String category;
	private Long personId;
	private String titel;
	
	public EventDTO() {}
	
	public EventDTO(Long id, String description, LocalDateTime startDate, LocalDateTime endDate, String location, int progress,
			String category, Long personId, String titel) {
		super();
		this.id = id;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
		this.progress = progress;
		this.category = category;
		this.titel = titel;
		this.personId = personId;
	}
	public Long getId() {
		return id;
	}
	
	public void setTitel(String titel) {
		this.titel = titel;
	}
	
	public String getTitel() {
		return this.titel;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	
}
