package dhbw.eiCompany.controller;

import dhbw.eiCompany.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import dhbw.eiCompany.database.Entry;
import dhbw.eiCompany.repositories.EntryRepository;

import java.util.List;

@RestController
public class EntryController {

    @Autowired
    EntryService entryService;

    @PostMapping(path = "/entry")
    private Long saveEntry(@RequestBody Entry entry){
        entryService.saveOrUpdate(entry);
        return entry.getEntryId();
    }

    @DeleteMapping(path = "/entries/{id}")
    private void deleteEntry(@PathVariable("id") Long entryId){
        entryService.delete(entryId);
    }

    @GetMapping(path = "/entries/{id}")
    private Entry findById(@PathVariable("id") Long entryId){
        return entryService.findById(entryId);
    }

    @GetMapping(path = "/entries")
    private List<Entry> getAllEntries(){
        return entryService.getAllEntries();
    }


}
