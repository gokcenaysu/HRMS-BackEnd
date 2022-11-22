package kodlama.io.hrms.repository;

import kodlama.io.hrms.model.concretes.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel,Integer> {

    Personnel findById(int id);
}
