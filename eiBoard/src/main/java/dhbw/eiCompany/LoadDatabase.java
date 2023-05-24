package dhbw.eiCompany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dhbw.eiCompany.repositories.TypeRepository;
import dhbw.eiCompany.repositories.UsersRepository;

@Configuration
public class LoadDatabase {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    TypeRepository typeRepository;



    @Bean
	public CommandLineRunner initDatabase() {
		return args -> {

//        Person julian = new Person();
//        julian.setName("Julian Stadler");
//        julian.setEmail("julian@stadler-privat.de");
//        julian.setPassword("1234");
//        julian.setEntryId("1");
//        julian.setPicture("test");
//        julian.setRang(Rank.USER);
//        julian.setDescription("test");
//        usersRepository.save(julian);
//
//        Person eileen = new Person();
//        eileen.setName("Eileen Staar");
//        eileen.setEmail("eileen@swr-rip-newszone.com");
//        eileen.setPassword("Vegan4Ever");
//        eileen.setEntryId("1");
//        eileen.setPicture("http://onlyfans.de/eileen");
//        eileen.setRang(Rank.ADMIN);
//        eileen.setDescription("Hey, ich bin Eileen und ich bin ein Veganer und habe ein schönes veganes Leben");
//        usersRepository.save(eileen);
//
//        Person test = new Person();
//        test.setName("test");
//        test.setEmail("test");
//        test.setPassword("test");
//        test.setEntryId("test");
//        test.setPicture("test");
//        test.setRang(Rank.USER);
//        test.setDescription("test");
//        usersRepository.save(test);
//
//        Entry testEntry = new Entry();
//        testEntry.setName("Testname");
//        testEntry.setDescription("Testbeschreibung");
//        testEntry.setColor(Color.GRAY);
//        testEntry.setDate(LocalDate.now());
//        testEntry.setTypId("TypID_1");
//        testEntry.setPerson(julian);
//        entryRepository.save(testEntry);
//
//        Entry testEntry2 = new Entry();
//        testEntry2.setName("test2");
//        testEntry2.setDescription("Testbeschreibung2");
//        testEntry2.setColor(Color.GRAY);
//        testEntry2.setDate(LocalDate.now());
//        testEntry2.setTypId("TypID_1_2");
//        testEntry2.setPerson(eileen);
//        entryRepository.save(testEntry2);
//
//        Type testType = new Type();
//        testType.setTypeName("testType");
//        testType.setTypeDescribtion("testDescribtion");
//        testType.setPriority(10);
//        testType.setForeignKey("test");
//        typeRepository.save(testType);
		};
    }
}
