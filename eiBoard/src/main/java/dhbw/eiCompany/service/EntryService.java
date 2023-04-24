package dhbw.eiCompany.service;

import java.util.List;

import dhbw.eiCompany.model.Entry;

public interface EntryService {

    Entry save(Entry entry);
    void delete(Long entryId);

    Entry findById(Long entryId);
    List<Entry> getAllEntries();

}
