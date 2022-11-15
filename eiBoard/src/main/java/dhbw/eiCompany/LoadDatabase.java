package dhbw.eiCompany;

import dhbw.eiCompany.database.*;
import dhbw.eiCompany.repositories.EntryRepository;
import dhbw.eiCompany.repositories.TypeRepository;
import dhbw.eiCompany.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.awt.*;
import java.time.LocalDate;

@Component
public class LoadDatabase {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    EntryRepository entryRepository;

    @PostConstruct
    public void loadDatabase(){

        Users julian = new Users();
        julian.setName("Julian Stadler");
        julian.setEmail("julian@stadler-privat.de");
        julian.setPassword("1234");
        julian.setEntryId("1");
        julian.setPicture("test");
        julian.setRang(UserRang.USER);
        julian.setDescribtion("test");



        Users test = new Users();
        test.setName("test");
        test.setEmail("test");
        test.setPassword("test");
        test.setEntryId("test");
        test.setPicture("test");
        test.setRang(UserRang.USER);
        test.setDescribtion("test");


        Entry testEntry = new Entry();
        testEntry.setName("Testname");
        testEntry.setDescribtion("Testbeschreibung");
        testEntry.setColor(Color.GRAY);
        testEntry.setDate(LocalDate.now());
        testEntry.setTypId("TypID_1");
        testEntry.setUser("Std1x");

        Type testType = new Type();
        testType.setTypeName("testType");
        testType.setTypeDescribtion("testDescribtion");
        testType.setPriority(10);
        testType.setForeignKey("test");

    }
}
