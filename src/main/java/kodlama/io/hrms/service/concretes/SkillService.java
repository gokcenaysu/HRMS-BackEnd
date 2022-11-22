package kodlama.io.hrms.service.concretes;

import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.repository.SkillRepository;
import kodlama.io.hrms.model.concretes.Skill;
import kodlama.io.hrms.model.dtos.CreateResumeDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    private final SkillRepository repository;
    private final ModelMapper modelMapper;

    public SkillService(SkillRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public Result add(CreateResumeDto createResumeDto) {
        Skill skill = modelMapper.map(createResumeDto, Skill.class);
        this.repository.save(skill);
        return new SuccessResult("ok");
    }

    public Result addAll(List<Skill> skill) {
        this.repository.saveAll(skill);
        return new SuccessResult("ok");
    }

    public Result delete(Skill skill) {
        this.repository.delete(skill);
        return new SuccessResult("ok");
    }

    public DataResult<List<Skill>> findAll() {
        return new SuccessDataResult<List<Skill>>(this.repository.findAll(), "ok");
    }

    public DataResult<Skill> findById(int id) {
        Skill skill = this.repository.findById(id);
        if (skill == null)
            return new ErrorDataResult<Skill>("no");
        return new SuccessDataResult<Skill>("ok");
    }

    public DataResult<List<Skill>> findAllByJobSeekerId(int id) {
        return new SuccessDataResult<List<Skill>>(this.repository.findAllByJobSeekerId(id));
    }
}
