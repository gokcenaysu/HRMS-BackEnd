package kodlama.io.hrms.service.concretes;

import kodlama.io.hrms.model.dtos.CreateResumeDto;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.repository.ExperienceRepository;
import kodlama.io.hrms.model.concretes.Experience;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService {

    private final ExperienceRepository repository;
    private final ModelMapper modelMapper;

    public ExperienceService(ExperienceRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }


    public Result add(CreateResumeDto createResumeDto) {
        Experience experience = this.modelMapper.map(createResumeDto, Experience.class);
        this.repository.save(experience);
        return new SuccessResult("ok");
    }

    public Result addAll(List<Experience> experience) {
        this.repository.saveAll(experience);
        return new SuccessResult("ok");
    }

    public Result delete(Experience experience) {
        this.repository.delete(experience);
        return new SuccessResult("ok");
    }

    public DataResult<List<Experience>> findAll() {
        return new SuccessDataResult<List<Experience>>(this.repository.findAll(), "ok");
    }

    public DataResult<Experience> findById(int id) {
        Experience experience = this.repository.findById(id);
        if (experience == null)
            return new ErrorDataResult<Experience>("no");
        return new SuccessDataResult<Experience>("ok");
    }

    public DataResult<List<Experience>> findAllByJobSeekerId(int id) {
        return new SuccessDataResult<List<Experience>>(this.repository.findAllByJobSeekerId(id));
    }
}
