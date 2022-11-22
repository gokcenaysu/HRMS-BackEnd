package kodlama.io.hrms.service.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.Faculty;

import java.util.List;

public interface FacultyService {

    Result add  (Faculty faculty);
    Result addAll (List<Faculty> faculty);
    Result delete(Faculty faculty);
    DataResult<List<Faculty>> findAll();
    DataResult<Faculty> findById(int id);
   // DataResult<List<Faculty>> findAllByJobSeekerId(int id);
}
