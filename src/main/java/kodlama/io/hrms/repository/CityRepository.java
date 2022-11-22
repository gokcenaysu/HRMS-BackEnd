package kodlama.io.hrms.repository;

import kodlama.io.hrms.model.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City,Integer> {

    City findById (int id);
    
}
