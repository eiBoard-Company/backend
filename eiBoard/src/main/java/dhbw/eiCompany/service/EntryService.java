package dhbw.eiCompany.service;

import dhbw.eiCompany.database.Entry;

import java.util.List;

public interface EntryService {

    void saveOrUpdate(Entry entry);
    void delete(Long entryId);

    Entry findById(Long entryId);
    List<Entry> getAllEntries();

}
