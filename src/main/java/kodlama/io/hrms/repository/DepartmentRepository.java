package kodlama.io.hrms.repository;

import kodlama.io.hrms.model.concretes.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    Department findById (int id);

}
