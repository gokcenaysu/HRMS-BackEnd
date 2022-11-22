package kodlama.io.hrms.repository;

import kodlama.io.hrms.model.concretes.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

    Faculty findById (int id);
    //List<Faculty> findAllByJobSeekerId(int id);


}
