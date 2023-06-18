package dhbw.eiCompany.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dhbw.eiCompany.model.Event;
import dhbw.eiCompany.repositories.EventRepository;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EventServiceTest {

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private EventService eventService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Order(1)
    public void testFindById() {
        // Mocking
        Long eventId = 1L;
        Event event = new Event();
        event.setId(eventId);
        when(eventRepository.findById(eventId)).thenReturn(Optional.of(event));

        // Test
        Event result = eventService.findById(eventId);

        // Assertion
        assertEquals(event, result);
    }

    @Test
    @Order(2)
    public void testCreateEvent() {
        // Mocking
        Event event = new Event();
        when(eventRepository.save(event)).thenReturn(event);

        // Test
        Event result = eventService.createEvent(event);

        // Assertion
        assertEquals(event, result);
    }

    @Test
    @Order(3)
    public void testUpdateEvent() {
        // Mocking
        Event updatedEvent = new Event();
        when(eventRepository.save(updatedEvent)).thenReturn(updatedEvent);

        // Test
        Event result = eventService.updateEvent(updatedEvent);

        // Assertion
        assertEquals(updatedEvent, result);
    }

    @Test
    @Order(4)
    public void testDeleteById() {
        // Test
        assertDoesNotThrow(() -> eventService.deleteById(1L));

        // Verification
        verify(eventRepository, times(1)).deleteById(1L);
    }

    @Test
    @Order(5)
    public void testDeleteByEvent() {
        // Mocking
        Event event = new Event();

        // Test
        assertDoesNotThrow(() -> eventService.deleteByEvent(event));

        // Verification
        verify(eventRepository, times(1)).delete(event);
    }

    @Test
    @Order(6)
    public void testAddProgress() {
        // Mocking
        Long eventId = 1L;
        Event event = new Event();
        event.setId(eventId);
        event.setProgress(50);
        when(eventRepository.findById(eventId)).thenReturn(Optional.of(event));

        // Test
        int addedPercent = eventService.addProgress(eventId, 30);

        // Assertion
        assertEquals(80, addedPercent);
        verify(eventRepository, times(1)).save(event);
    }

    @Test
    @Order(7)
    public void testAddProgress_Exceeds100() {
        // Mocking
        Long eventId = 1L;
        Event event = new Event();
        event.setId(eventId);
        event.setProgress(90);
        when(eventRepository.findById(eventId)).thenReturn(Optional.of(event));

        // Test
        int addedPercent = eventService.addProgress(eventId, 20);

        // Assertion
        assertEquals(0, addedPercent);
        verify(eventRepository, never()).save(any());
    }

    @Test
    @Order(8)
    public void testSetProgress() {
        // Mocking
        Long eventId = 1L;
        Event event = new Event();
        event.setId(eventId);
        when(eventRepository.findById(eventId)).thenReturn(Optional.of(event));

        // Test
        int percentToSet = 70;
        int setProgressResult = eventService.setProgress(eventId, percentToSet);

        // Assertion
        assertEquals(percentToSet, setProgressResult);
        assertEquals(percentToSet, event.getProgress());
        verify(eventRepository, times(1)).save(event);
    }

    @Test
    @Order(9)
    public void testSetProgress_Exceeds100() {
        // Mocking
        Long eventId = 1L;
        Event event = new Event();
        event.setId(eventId);
        when(eventRepository.findById(eventId)).thenReturn(Optional.of(event));

        // Test
        int percentToSet = 120;
        int setProgressResult = eventService.setProgress(eventId, percentToSet);

        // Assertion
        assertEquals(0, setProgressResult);
        verify(eventRepository, never()).save(any());
    }

    @Test
    @Order(10)
    public void testFindAll() {
        // Mocking
        List<Event> events = new ArrayList<>();
        when(eventRepository.findAll()).thenReturn(events);

        // Test
        List<Event> result = eventService.findAll();

        // Assertion
        assertEquals(events, result);
    }
}
