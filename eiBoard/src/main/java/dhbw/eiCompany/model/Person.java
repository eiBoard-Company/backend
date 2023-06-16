package dhbw.eiCompany.model;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity(name = "PERSON")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    
    @NotNull
    @Column
    private String lastName;
    
    @Column
    @NotNull
    private String firstName;

    @Column
    @Email
    private String email;
    
    @Column
    @Lob
    private Blob picture;
    
    @Column
    private String raplaLink;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "person", orphanRemoval = true)
    private List<Task> tasks = new ArrayList<>();
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "person", orphanRemoval = true)
    private List<Event> events = new ArrayList<>();
    
    private String password;
    
    
    public Person(){

    }

    public Person(Long userId, String lastName, String firstName, String password, String email, Blob picture, String raplaLink) {
    	this.raplaLink = raplaLink;
        this.userId = userId;
        this.email = email;
        this.picture = picture;
        this.lastName = lastName;
        this.firstName = firstName;
    }
    
    

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}
	
	

	public String getRaplaLink() {
		return raplaLink;
	}

	public void setRaplaLink(String raplaLink) {
		this.raplaLink = raplaLink;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public Blob getPicture() {
		return picture;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

   
}
