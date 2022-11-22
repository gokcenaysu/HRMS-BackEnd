package kodlama.io.hrms.service.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.Experience;
import kodlama.io.hrms.model.dtos.CreateResumeDto;

import java.util.List;

public interface ExperienceService {

    Result add (CreateResumeDto createResumeDto);
    Result addAll (List<Experience> experience);
    Result delete(Experience experience);
    DataResult<List<Experience>> findAll();
    DataResult<Experience> findById(int id);
    DataResult<List<Experience>> findAllByJobSeekerId(int id);

}
