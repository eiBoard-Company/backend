package dhbw.eiCompany.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import dhbw.eiCompany.model.Event;
import dhbw.eiCompany.model.Task;

public class PersonDTO {

	private Long id;
	private String lastName;
	private String firstName;
	private String email;
	private String picture;
	private String raplaLink;
	private List<TaskDTO> taks = new ArrayList<>();
	private List<EventDTO> events = new ArrayList<>();
	
	
	public PersonDTO() {}
	
	public PersonDTO(Long id, String lastName, String firstName, String email, String picture, String raplaLink) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.picture = picture;
		this.raplaLink = raplaLink;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getRaplaLink() {
		return raplaLink;
	}
	public void setRaplaLink(String raplaLink) {
		this.raplaLink = raplaLink;
	}

	public List<TaskDTO> getTaks() {
		return taks;
	}

	public void setTaks(List<TaskDTO> taks) {
		this.taks = taks;
	}

	public List<EventDTO> getEvents() {
		return events;
	}

	public void setEvents(List<EventDTO> events) {
		this.events = events;
	}

	
	
	
}

