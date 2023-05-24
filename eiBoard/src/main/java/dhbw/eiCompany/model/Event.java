package dhbw.eiCompany.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Event")
@Table(name = "Event")
public class Event {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column
	private String titel;
	@Column
	private String description;
	@Column
	private LocalDate date;
	@Column
	private LocalDate startDate;
	@Column
	private LocalDate endDate;
	@Column
	private String location;
	@Column
	private int progress;
	@Column
	private String category;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Person person;
	
	public Event() {
		
	}
	
	
	public Event(String titel, String description, LocalDate date, LocalDate startDate, LocalDate endDate,
			String location, int progress, String category) {
		super();
		this.titel = titel;
		this.description = description;
		this.date = date;
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
		this.progress = progress;
		this.category = category;
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

	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}


	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
