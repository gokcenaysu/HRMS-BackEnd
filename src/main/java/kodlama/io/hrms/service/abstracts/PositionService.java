package kodlama.io.hrms.service.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.Position;

import java.util.List;

public interface PositionService {

    DataResult<List<Position>> findAll();
    DataResult<List<Position>> findAll(int pageNo, int pageSize);
    DataResult<List<Position>> findAllSortedAsc();
    DataResult<Position> findById(int id);
    Result add(Position position);
    Result delete(Position position);
    DataResult<List<Position>> findByPositionContains (String position);
}
