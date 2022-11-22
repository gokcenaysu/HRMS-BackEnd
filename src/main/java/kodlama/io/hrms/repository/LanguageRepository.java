package kodlama.io.hrms.repository;

import kodlama.io.hrms.model.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {

    Language findById (int id);
    List<Language> findAllByJobSeekerId(int id);

}
