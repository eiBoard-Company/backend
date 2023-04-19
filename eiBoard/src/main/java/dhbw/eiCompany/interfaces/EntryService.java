package dhbw.eiCompany.interfaces;

import dhbw.eiCompany.database.Entry;

import java.util.List;

public interface EntryService {

    void save(Entry entry);
    void delete(Long entryId);

    Entry findById(Long entryId);
    List<Entry> getAllEntries();

}
