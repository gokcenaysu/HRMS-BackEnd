package kodlama.io.hrms.service.concretes;

import kodlama.io.hrms.service.abstracts.SkillService;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.repository.SkillRepository;
import kodlama.io.hrms.model.concretes.Skill;
import kodlama.io.hrms.model.dtos.CreateResumeDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillManager implements SkillService {

    @Autowired
    private SkillRepository skillRepository;
    private ModelMapper modelMapper;

    public SkillManager(SkillRepository skillRepository, ModelMapper modelMapper) {
        this.skillRepository = skillRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result add(CreateResumeDto createResumeDto) {
        Skill skill = modelMapper.map(createResumeDto, Skill.class);
        this.skillRepository.save(skill);
        return new SuccessResult("ok");
    }

    @Override
    public Result addAll(List<Skill> skill) {
        this.skillRepository.saveAll(skill);
        return new SuccessResult("ok");
    }

    @Override
    public Result delete(Skill skill) {
        this.skillRepository.delete(skill);
        return new SuccessResult("ok");
    }

    @Override
    public DataResult<List<Skill>> findAll() {
        return new SuccessDataResult<List<Skill>>(this.skillRepository.findAll(),"ok");
    }

    @Override
    public DataResult<Skill> findById(int id) {
        Skill skill = this.skillRepository.findById(id);
        if(skill ==null)
            return new ErrorDataResult<Skill>("no");
        return new SuccessDataResult<Skill>("ok");
    }

    @Override
    public DataResult<List<Skill>> findAllByJobSeekerId(int id) {
        return new SuccessDataResult<List<Skill>>(this.skillRepository.findAllByJobSeekerId(id));
    }
}
