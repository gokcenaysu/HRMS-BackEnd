package kodlama.io.hrms.repository;

import kodlama.io.hrms.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByEmail(String email);
    User findByPasswordEquals(String password);
    User findById (int id);

}
