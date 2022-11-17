package dhbw.eiCompany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dhbw.eiCompany.database.Entries;

@Repository
public interface EntryRepository extends JpaRepository<Entries, Long> {
	Entries findByName(String name);
}
