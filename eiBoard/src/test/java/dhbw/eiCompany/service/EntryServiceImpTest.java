//package dhbw.eiCompany.service;
//
//import dhbw.eiCompany.model.Entry;
//import dhbw.eiCompany.repositories.EntryRepository;
//import org.junit.jupiter.api.*;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.*;
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class EntryServiceImpTest {
//
//    @Mock
//    private EntryRepository entryRepository;
//
//    @InjectMocks
//    private EntryServiceImp entryService;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    @Order(1)
//    public void save() {
//        Entry entry = new Entry();
//        when(entryRepository.save(entry)).thenReturn(entry);
//
//        Entry savedEntry = entryService.save(entry);
//
//        assertEquals(entry, savedEntry);
//        verify(entryRepository, times(1)).save(entry);
//    }
//
//    @Test
//    @Order(2)
//    public void delete() {
//        Long entryId = 1L;
//
//        entryService.delete(entryId);
//
//        verify(entryRepository, times(1)).deleteById(entryId);
//    }
//
//    @Test
//    @Order(3)
//    public void findById() {
//        Long entryId = 1L;
//        Entry entry = new Entry();
//        when(entryRepository.findById(entryId)).thenReturn(Optional.of(entry));
//
//        Entry foundEntry = entryService.findById(entryId);
//
//        assertEquals(entry, foundEntry);
//
//        when(entryRepository.findById(entryId)).thenReturn(Optional.empty());
//
//        assertThrows(NoSuchElementException.class, () -> entryService.findById(entryId));
//    }
//
//    @Test
//    @Order(4)
//    public void getAllEntries() {
//        List<Entry> entryList = new ArrayList<>();
//        entryList.add(new Entry());
//        when(entryRepository.findAll()).thenReturn(entryList);
//
//        List<Entry> allEntries = entryService.getAllEntries();
//
//        assertEquals(entryList.size(), allEntries.size());
//        assertEquals(entryList.get(0), allEntries.get(0));
//    }
//}
