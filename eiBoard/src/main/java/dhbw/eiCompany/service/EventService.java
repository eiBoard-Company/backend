package dhbw.eiCompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dhbw.eiCompany.model.Event;
import dhbw.eiCompany.model.Task;
import dhbw.eiCompany.repositories.EventRepository;

@Service
public class EventService {

	@Autowired
	EventRepository eventRepository;
	
	public Event findById(Long id) {
		return eventRepository.findById(id).get();
	}
	
	public Event createEvent(Event event ) {
		return eventRepository.save(event);
	}
	
	public Event updateEvent(Event updatedEvent) {
		return eventRepository.save(updatedEvent);
	}
	
	public void deleteById(Long id) {
		eventRepository.deleteById(id);
	}
	
	public void deleteByEvent(Event event) {
		eventRepository.delete(event);
	}
	
	public int addProgress(Long id, int percentToAdd) {
		Event t = findById(id);
		int addedPercent = t.getProgress() + percentToAdd;
		if(addedPercent > 100) {
			// TODO: Throw error
			return 0;
		} else {
			t.setProgress(addedPercent);
			updateEvent(t);
			return addedPercent;
		}
		
	}
	
	public int setProgress(Long id, int percentToSet) {
		Event t = findById(id);
		if(percentToSet > 100) {
			// TODO: Throw error
			return 0;
		} else {
			t.setProgress(percentToSet);
			updateEvent(t);
			return percentToSet;
		}
		
	}

	public List<Event> findAll() {
		// TODO Auto-generated method stub
		return eventRepository.findAll();
	}


}
