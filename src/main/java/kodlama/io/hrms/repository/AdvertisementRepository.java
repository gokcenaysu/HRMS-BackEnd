package kodlama.io.hrms.repository;

import kodlama.io.hrms.model.concretes.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Integer> {

    Advertisement findById(int id);
    List<Advertisement> findByActivityStatus(boolean activityStatus);
    List<Advertisement> findByOrderByCreationDate();
    List<Advertisement> findByOrderByApplicationDeadline();
    List<Advertisement> findByActivityStatusAndEmployerId(boolean activityStatus, int employerId);

}
