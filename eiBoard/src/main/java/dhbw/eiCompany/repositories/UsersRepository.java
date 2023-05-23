package dhbw.eiCompany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dhbw.eiCompany.model.Person;


@Repository
public interface UsersRepository extends JpaRepository<Person, Long> {

    Person findByName(String name);

}
