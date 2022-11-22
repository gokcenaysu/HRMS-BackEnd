package kodlama.io.hrms.service.concretes;

import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.repository.UniversityRepository;
import kodlama.io.hrms.model.concretes.University;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService {

    private final UniversityRepository repository;
    private final ModelMapper modelMapper;

    public UniversityService(UniversityRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public Result add(University university) {
        this.repository.save(university);
        return new SuccessResult("ok");
    }

    public Result addAll(List<University> university) {
        this.repository.saveAll(university);
        return new SuccessResult("ok");
    }

    public Result delete(University university) {
        this.repository.delete(university);
        return new SuccessResult("ok");
    }

    public DataResult<List<University>> findAll() {
        return new SuccessDataResult<List<University>>(this.repository.findAll(), "ok");
    }

    public DataResult<University> findById(int id) {
        University university = this.repository.findById(id).orElse(null);
        if (university == null)
            return new ErrorDataResult<University>("no");
        return new SuccessDataResult<University>(university, "ok");
    }

    public DataResult<List<University>> findAllByJobSeekerId(int id) {
        return new SuccessDataResult<List<University>>(this.repository.findAllByJobSeekerId(id));
    }
}
