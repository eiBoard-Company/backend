package dhbw.eiCompany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dhbw.eiCompany.database.Person;

@Repository
public interface UsersRepository extends JpaRepository<Person, Long> {
    // gerneriert SQL String damit wir auf Objekte mit dem Name finden können
	Person findByName(String name);
}
