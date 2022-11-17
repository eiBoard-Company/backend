package dhbw.eiCompany;

import dhbw.eiCompany.database.*;
import dhbw.eiCompany.repositories.EntryRepository;
import dhbw.eiCompany.repositories.TypeRepository;
import dhbw.eiCompany.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.awt.*;
import java.time.LocalDate;

@Configuration
public class LoadDatabase {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    EntryRepository entryRepository;

    @Bean
	public CommandLineRunner initDatabase() {
		return args -> {

        Person julian = new Person();
        julian.setName("Julian Stadler");
        julian.setEmail("julian@stadler-privat.de");
        julian.setPassword("1234");
        julian.setEntryId("1");
        julian.setPicture("test");
        julian.setRang(Rank.USER);
        julian.setDescribtion("test");
        usersRepository.save(julian);

        Person eileen = new Person();
        eileen.setName("Eileen Staar");
        eileen.setEmail("eileen@swr-rip-newszone.com");
        eileen.setPassword("Vegan4Ever");
        eileen.setEntryId("1");
        eileen.setPicture("http://onlyfans.de/eileen");
        eileen.setRang(Rank.ADMIN);
        eileen.setDescribtion("Hey, ich bin Eileen und ich bin ein Veganer und habe ein schönes veganes Leben");
        usersRepository.save(eileen);

        Person test = new Person();
        test.setName("test");
        test.setEmail("test");
        test.setPassword("test");
        test.setEntryId("test");
        test.setPicture("test");
        test.setRang(Rank.USER);
        test.setDescribtion("test");
        usersRepository.save(test);

        Entries testEntry = new Entries();
        testEntry.setName("Testname");
        testEntry.setDescription("Testbeschreibung");
        testEntry.setColor(Color.GRAY);
        testEntry.setDate(LocalDate.now());
        testEntry.setTypId("TypID_1");
        testEntry.setPerson("Std1x");
        entryRepository.save(testEntry);

        Type testType = new Type();
        testType.setTypeName("testType");
        testType.setTypeDescribtion("testDescribtion");
        testType.setPriority(10);
        testType.setForeignKey("test");
        typeRepository.save(testType);
		};
    }
}
