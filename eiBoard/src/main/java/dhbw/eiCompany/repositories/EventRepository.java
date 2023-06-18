package dhbw.eiCompany.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dhbw.eiCompany.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {


}
