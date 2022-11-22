package kodlama.io.hrms.repository;

import kodlama.io.hrms.model.concretes.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer> {

    Experience findById (int id);
    List<Experience> findAllByJobSeekerId(int id);


}
