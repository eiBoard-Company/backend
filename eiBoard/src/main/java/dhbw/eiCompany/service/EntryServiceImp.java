package dhbw.eiCompany.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dhbw.eiCompany.model.Entry;
import dhbw.eiCompany.repositories.EntryRepository;

@Service
public class EntryServiceImp implements EntryService{

    @Autowired
    EntryRepository entryRepository;

    @Override
    public Entry save(Entry entry) {
       return  entryRepository.save(entry);
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
