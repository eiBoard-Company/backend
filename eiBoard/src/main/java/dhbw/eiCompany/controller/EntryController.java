package dhbw.eiCompany.controller;

import dhbw.eiCompany.database.Entry;
import dhbw.eiCompany.repositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntryController {

    @Autowired
    EntryRepository entryRepository;

    @GetMapping(path = "/entries/{name}")
    public Entry entry(@PathVariable String name){return entryRepository.findByName(name);}
}
