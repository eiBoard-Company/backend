package dhbw.eiCompany.repositories;

import java.sql.Blob;
import java.time.LocalDateTime;

import javax.persistence.Column;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dhbw.eiCompany.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
	 @Modifying
	  @Transactional
	  @Query(value = "UPDATE Task SET titel = ?1, description = ?2, endDate = ?3, status = ?4,progress= ?5, category=?6 WHERE id = ?7")
	  void updateTask(String titel, String description, LocalDateTime endDate, String status, double progress,String category, Long id);

		
}
