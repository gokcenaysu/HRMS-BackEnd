package kodlama.io.hrms.service.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.Link;
import kodlama.io.hrms.model.dtos.CreateResumeDto;

import java.util.List;

public interface LinkService {

    Result add(CreateResumeDto createResumeDto);
    Result addAll (List<Link> link);
    Result delete(Link link);
    DataResult<List<Link>> findAll();
    DataResult<Link> findById(int id);
    DataResult<List<Link>> findAllByJobSeekerId(int id);

}
