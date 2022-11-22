package kodlama.io.hrms.repository;

import kodlama.io.hrms.model.concretes.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {

    Skill findById (int id);
    List<Skill> findAllByJobSeekerId(int id);

}
