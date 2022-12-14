package kodlama.io.hrms.repository;

import kodlama.io.hrms.model.concretes.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityRepository extends JpaRepository<University, Integer> {

    //University findById (int id);
    List<University> findAllByJobSeekerId(int id);


}
