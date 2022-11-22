package kodlama.io.hrms.repository;

import kodlama.io.hrms.model.concretes.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinkRepository extends JpaRepository<Link, Integer> {

    Link findById (int id);
    List<Link> findAllByJobSeekerId(int id);

}
