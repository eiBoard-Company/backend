package dhbw.eiCompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dhbw.eiCompany.database.Entry;
import dhbw.eiCompany.interfaces.EntryService;

import java.util.List;

@RestController
public class EntryController {

    @Autowired
    EntryService entryService;

    @PostMapping(path = "/entry")
    private ResponseEntity<Long> saveEntry(@RequestBody Entry entry){
        entryService.save(entry);
        return new ResponseEntity<>(entry.getEntryId(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/entries/{id}")
    private ResponseEntity<Entry> deleteEntry(@PathVariable("id") Long entryId){
        entryService.delete(entryId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/entries/{id}")
    private ResponseEntity<Entry> findById(@PathVariable("id") Long entryId){
        return new ResponseEntity<>(entryService.findById(entryId), HttpStatus.OK);
    }

    @GetMapping(path = "/entries")
    private ResponseEntity<List<Entry>> getAllEntries(){
        return new ResponseEntity<>(entryService.getAllEntries(), HttpStatus.OK);
    }


}
