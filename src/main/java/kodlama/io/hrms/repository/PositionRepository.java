package kodlama.io.hrms.repository;

import kodlama.io.hrms.model.concretes.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<Position,Integer> {

    Position findById(int id);
    boolean existsByName (String name);
    List<Position> findByNameContains(String name);
    Page<Position> findAll(Pageable pageable);
}
