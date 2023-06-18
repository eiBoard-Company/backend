package dhbw.eiCompany.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import dhbw.eiCompany.dto.TaskDTO;
import dhbw.eiCompany.mapper.TaskMapper;
import dhbw.eiCompany.model.Task;
import dhbw.eiCompany.repositories.TaskRepository;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private TaskMapper taskMapper;

    @InjectMocks
    private TaskService taskService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Order(1)
    public void testFindAll() {
        // Mocking
        List<Task> tasks = new ArrayList<>();
        when(taskRepository.findAll()).thenReturn(tasks);

        // Test
        List<Task> result = taskService.findAll();

        // Assertion
        assertEquals(tasks, result);
    }

    @Test
    @Order(2)
    public void testSaveOrUpdate() {
        // Mocking
        Task task = new Task();
        when(taskRepository.save(task)).thenReturn(task);

        // Test
        Task result = taskService.saveOrUpdate(task);

        // Assertion
        assertEquals(task, result);
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    @Order(3)
    public void testFindById() {
        // Mocking
        Long taskId = 1L;
        Task task = new Task();
        when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));

        // Test
        Task result = taskService.findById(taskId);

        // Assertion
        assertEquals(task, result);
    }

    @Test
    @Order(4)
    public void testDeleteById() {
        // Test
        assertDoesNotThrow(() -> taskService.deleteById(1L));

        // Verification
        verify(taskRepository, times(1)).deleteById(1L);
    }

    @Test
    @Order(5)
    public void testDeleteByTask() {
        // Mocking
        Task task = new Task();

        // Test
        assertDoesNotThrow(() -> taskService.deleteByTask(task));

        // Verification
        verify(taskRepository, times(1)).delete(task);
    }

    @Test
    @Order(6)
    public void testUpdateTask() {
        // Mocking
        Task task = new Task();
        when(taskRepository.save(task)).thenReturn(task);

        // Test
        Task result = taskService.updateTask(task);

        // Assertion
        assertEquals(task, result);
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    @Order(7)
    public void testUpdatedStatus_DoneToNotDone() {
        // Mocking
        Long taskId = 1L;
        Task task = new Task();
        task.setStatus("Done");
        when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));
        when(taskRepository.save(task)).thenReturn(task);

        // Test
        String result = taskService.updatedStatus(taskId);

        // Assertion
        assertEquals("Not done", result);
        verify(taskRepository, times(1)).findById(taskId);
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    @Order(8)
    public void testUpdatedStatus_NotDoneToDone() {
        // Mocking
        Long taskId = 1L;
        Task task = new Task();
        task.setStatus("Not done");
        when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));
        when(taskRepository.save(task)).thenReturn(task);

        // Test
        String result = taskService.updatedStatus(taskId);

        // Assertion
        assertEquals("Done", result);
        verify(taskRepository, times(1)).findById(taskId);
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    @Order(9)
    public void testAddProgress_ValidPercent() {
        // Mocking
        Long taskId = 1L;
        Task task = new Task();
        task.setProgress(50);
        when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));
        when(taskRepository.save(task)).thenReturn(task);

        // Test
        double result = taskService.addProgress(taskId, 25.5);

        // Assertion
        assertEquals(75.5, result);
        verify(taskRepository, times(1)).findById(taskId);
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    @Order(10)
    public void testAddProgress_ExceedingPercent() {
        // Mocking
        Long taskId = 1L;
        Task task = new Task();
        task.setProgress(80);
        when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));

        // Test
        double result = taskService.addProgress(taskId, 30);

        // Assertion
        assertEquals(0, result);
        verify(taskRepository, times(1)).findById(taskId);
        verify(taskRepository, never()).save(task);
    }

    @Test
    @Order(11)
    public void testSetProgress_ValidPercent() {
        // Mocking
        Long taskId = 1L;
        Task task = new Task();
        when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));
        when(taskRepository.save(task)).thenReturn(task);

        // Test
        double result = taskService.setProgress(taskId, 75.5);

        // Assertion
        assertEquals(75.5, result);
        verify(taskRepository, times(1)).findById(taskId);
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    @Order(12)
    public void testSetProgress_ExceedingPercent() {
        // Mocking
        Long taskId = 1L;
        Task task = new Task();
        when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));

        // Test
        double result = taskService.setProgress(taskId, 120);

        // Assertion
        assertEquals(0, result);
        verify(taskRepository, times(1)).findById(taskId);
        verify(taskRepository, never()).save(task);
    }

}
