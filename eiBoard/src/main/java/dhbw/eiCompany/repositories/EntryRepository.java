package dhbw.eiCompany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dhbw.eiCompany.database.Entry;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {

}
