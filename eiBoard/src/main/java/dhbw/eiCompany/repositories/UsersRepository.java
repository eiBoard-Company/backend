package dhbw.eiCompany.repositories;

import dhbw.eiCompany.database.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
    // gerneriert SQL String damit wir auf Objekte mit dem Name finden können
    User findByName(String name);
}
