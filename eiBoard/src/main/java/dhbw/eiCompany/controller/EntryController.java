package dhbw.eiCompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dhbw.eiCompany.database.Entries;
import dhbw.eiCompany.repositories.EntryRepository;

@RestController
public class EntryController {

    @Autowired
    EntryRepository entryRepository;

    @GetMapping(path = "/entries/{name}")
    public Entries entry(@PathVariable String name){return entryRepository.findByName(name);}
}
