package kodlama.io.hrms.service.concretes;

import kodlama.io.hrms.model.dtos.CreateResumeDto;
import kodlama.io.hrms.service.abstracts.ExperienceService;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.repository.ExperienceRepository;
import kodlama.io.hrms.model.concretes.Experience;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceManager implements ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;
    private ModelMapper modelMapper;

    public ExperienceManager(ExperienceRepository experienceRepository, ModelMapper modelMapper) {
        this.experienceRepository = experienceRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public Result add(CreateResumeDto createResumeDto){
        Experience experience = this.modelMapper.map(createResumeDto, Experience.class);
        this.experienceRepository.save(experience);
        return new SuccessResult("ok");
    }

    @Override
    public Result addAll(List<Experience> experience) {
        this.experienceRepository.saveAll(experience);
        return new SuccessResult("ok");
    }

    @Override
    public Result delete(Experience experience) {
        this.experienceRepository.delete(experience);
        return new SuccessResult("ok");
    }

    @Override
    public DataResult<List<Experience>> findAll() {
        return new SuccessDataResult<List<Experience>>(this.experienceRepository.findAll(),"ok");
    }

    @Override
    public DataResult<Experience> findById(int id) {
        Experience experience = this.experienceRepository.findById(id);
        if(experience==null)
            return new ErrorDataResult<Experience>("no");
        return new SuccessDataResult<Experience>("ok");
    }

    @Override
    public DataResult<List<Experience>> findAllByJobSeekerId(int id) {
        return new SuccessDataResult<List<Experience>>(this.experienceRepository.findAllByJobSeekerId(id));
    }
}
