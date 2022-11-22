package kodlama.io.hrms.service.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.JobSeeker;
import kodlama.io.hrms.model.dtos.CreateResumeDto;

import java.util.List;


public interface JobSeekerService {

    DataResult<List<JobSeeker>> findAll();
    DataResult<List<JobSeeker>> findAllSortedAsc();

    DataResult<JobSeeker> findById(int id);
    DataResult<CreateResumeDto> findResumeById(int id);


    Result register(JobSeeker jobSeeker);
    Result delete(JobSeeker jobSeeker);
    Result login (JobSeeker jobSeeker);


}
