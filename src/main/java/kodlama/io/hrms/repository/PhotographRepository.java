package kodlama.io.hrms.repository;

import kodlama.io.hrms.model.concretes.Photograph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotographRepository extends JpaRepository<Photograph, Integer> {

    Photograph findById (int id);
    List<Photograph> findAllByJobSeekerId(int id);

}
