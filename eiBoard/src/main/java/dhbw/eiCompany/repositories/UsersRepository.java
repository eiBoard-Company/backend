package dhbw.eiCompany.repositories;

import dhbw.eiCompany.database.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    // gerneriert SQL String damit wir auf Objekte mit dem Name finden können
    Users findByName(String name);
}
