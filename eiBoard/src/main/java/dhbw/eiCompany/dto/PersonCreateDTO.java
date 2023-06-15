package dhbw.eiCompany.dto;

public class PersonCreateDTO {
	
	private String lastName;
	private String firstName;
	private String email;
	
	public PersonCreateDTO (String lastName, String firstName, String email) {
		this.email = email;
		this.lastName = lastName;
		this.firstName = firstName;
	}

	
	public PersonCreateDTO() {
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
	
}
