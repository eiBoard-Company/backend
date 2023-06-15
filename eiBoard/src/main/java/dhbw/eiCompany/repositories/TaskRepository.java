package dhbw.eiCompany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dhbw.eiCompany.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

}
