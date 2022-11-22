package kodlama.io.hrms.service.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.University;

import java.util.List;

public interface UniversityService {

    Result add  (University university);
    Result addAll (List<University> university);
    Result delete(University university);
    DataResult<List<University>> findAll();
    DataResult<University> findById(int id);
    DataResult<List<University>> findAllByJobSeekerId(int id);
}
