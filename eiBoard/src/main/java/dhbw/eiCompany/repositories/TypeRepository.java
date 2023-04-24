package dhbw.eiCompany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dhbw.eiCompany.model.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
    Type findByTypeId(Long typId);
}
