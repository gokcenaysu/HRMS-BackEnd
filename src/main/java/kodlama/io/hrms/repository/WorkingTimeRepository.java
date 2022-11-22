package kodlama.io.hrms.repository;

import kodlama.io.hrms.model.concretes.WorkingTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkingTimeRepository extends JpaRepository<WorkingTime, Integer> {
}
