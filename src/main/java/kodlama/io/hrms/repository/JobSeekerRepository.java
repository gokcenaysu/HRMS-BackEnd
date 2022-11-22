package kodlama.io.hrms.repository;

import kodlama.io.hrms.model.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeeker,Integer> {

    boolean existsByIdentityNumber(String identityNumber);
    JobSeeker findById (int id);
    JobSeeker findByEmail (String email);
    JobSeeker findByIdentityNumber (String identityNumber);
    boolean existsByEmail(String email);


}
