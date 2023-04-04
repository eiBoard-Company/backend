package dhbw.eiCompany.service;

import dhbw.eiCompany.database.Entry;
import dhbw.eiCompany.interfaces.EntryService;
import dhbw.eiCompany.repositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntryServiceImp implements EntryService{

    @Autowired
    EntryRepository entryRepository;

    @Override
    public void save(Entry entry) {
        entryRepository.save(entry);
    }
    @Override
    public void delete(Long entryId) {
        entryRepository.deleteById(entryId);
    }

    @Override
    public Entry findById(Long entryId) {
        return entryRepository.findById(entryId).get();
    }

    @Override
    public List<Entry> getAllEntries() {
        return new ArrayList<>(entryRepository.findAll());
    }

}
