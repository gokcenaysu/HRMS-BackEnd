package kodlama.io.hrms.repository;

import kodlama.io.hrms.model.concretes.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {

    Admin findById(int id);
}
