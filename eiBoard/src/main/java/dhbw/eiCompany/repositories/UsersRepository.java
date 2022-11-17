package dhbw.eiCompany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dhbw.eiCompany.database.Person;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Person, Long> {

}
