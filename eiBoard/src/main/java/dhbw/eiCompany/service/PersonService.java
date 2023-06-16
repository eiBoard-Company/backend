package dhbw.eiCompany.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dhbw.eiCompany.configuration.Credentials;
import dhbw.eiCompany.configuration.KeycloakAdminclient;
import dhbw.eiCompany.dto.PersonDTO;
import dhbw.eiCompany.mapper.PersonMapper;
import dhbw.eiCompany.model.Event;
import dhbw.eiCompany.model.Person;
import dhbw.eiCompany.model.Task;
import dhbw.eiCompany.repositories.UsersRepository;

@Service
public class PersonService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    PersonMapper personMapper;
    
    public List<Person> getAllUser(){

        return new ArrayList<>(usersRepository.findAll());
    }
    
    public PersonService() {
    	
    }

    public ResponseEntity<PersonDTO> create(Person name){
       Person p = usersRepository.save(name);
   
       
       CredentialRepresentation credential = Credentials
               .createPasswordCredentials(name.getPassword());    UserRepresentation user = new UserRepresentation();
       user.setUsername(p.getEmail());
       user.setFirstName(p.getFirstName());
       user.setLastName(p.getLastName());
       user.setEmail(p.getEmail());
       user.setRealmRoles(List.of("User"));
       user.setCredentials(Collections.singletonList(credential));
       user.setEnabled(true);
       HashMap<String, List<String>> hm = new HashMap<>();
       hm.put("userID", List.of(String.valueOf(p.getUserId())));
       user.setAttributes(hm);

       UsersResource instance = getInstance();
   int code =   instance.create(user).getStatus();
   if(code != 201) {
	   usersRepository.deleteById(p.getUserId());
	   return new ResponseEntity<>(HttpStatus.CONFLICT);
   }
       
       return new ResponseEntity<>(personMapper.personToPersonDTO(p),HttpStatus.CREATED);
    }
    public Person update(Person name){
    	
    	
        return usersRepository.save(name);
     }
    public UsersResource getInstance(){
        return KeycloakAdminclient.getInstance().realm(KeycloakAdminclient.realm).users();
    }
    public void deleteById(Long id){
        usersRepository.deleteById(id);
    }

	public Person findById(Long id) {
		return usersRepository.findById(id).get();
	}
	
	public List<Task> getTasks(Long id) {
		return findById(id).getTasks();
	}
	public List<Event> getEvents(Long id) {
		return findById(id).getEvents();
	}
    
}
