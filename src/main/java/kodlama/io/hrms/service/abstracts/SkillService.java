package kodlama.io.hrms.service.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.Skill;
import kodlama.io.hrms.model.dtos.CreateResumeDto;

import java.util.List;

public interface SkillService {

    Result add(CreateResumeDto createResumeDto);
    Result addAll (List<Skill> skill);
    Result delete(Skill skill);
    DataResult<List<Skill>> findAll();
    DataResult<Skill> findById(int id);
    DataResult<List<Skill>> findAllByJobSeekerId(int id);

}
