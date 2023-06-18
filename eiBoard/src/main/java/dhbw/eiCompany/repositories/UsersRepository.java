package dhbw.eiCompany.repositories;

import java.sql.Blob;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dhbw.eiCompany.model.Person;


@Repository
public interface UsersRepository extends JpaRepository<Person, Long> {

  Person findByUserId(Long userID);
  @Modifying
  @Transactional
  @Query(value = "UPDATE PERSON SET picture = ?1, email = ?2, first_name = ?3, last_name = ?4,rapla_link= ?5 WHERE user_id = ?6")
  void updateUser(Blob picture, String email, String firstName, String lastName, String rapla, Long id);

}
