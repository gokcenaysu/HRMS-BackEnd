package kodlama.io.hrms.service.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.dtos.CreateResumeDto;


public interface ResumeService {

    Result add (CreateResumeDto createResumeDto, int id);
//    Result delete(Resume resume);
//    DataResult<List<Resume>> findAll();
//    DataResult<Resume> findById(int id);
}
