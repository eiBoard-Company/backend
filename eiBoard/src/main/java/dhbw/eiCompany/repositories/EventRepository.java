package dhbw.eiCompany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dhbw.eiCompany.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
