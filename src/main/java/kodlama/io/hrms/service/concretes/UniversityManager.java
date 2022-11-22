package kodlama.io.hrms.service.concretes;

import kodlama.io.hrms.service.abstracts.UniversityService;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.repository.UniversityRepository;
import kodlama.io.hrms.model.concretes.University;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityManager implements UniversityService {

    @Autowired
    private UniversityRepository universityRepository;
    private ModelMapper modelMapper;

    public UniversityManager(UniversityRepository universityRepository, ModelMapper modelMapper) {
        this.universityRepository = universityRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public Result add(University university) {
        this.universityRepository.save(university);
        return new SuccessResult("ok");
    }

    @Override
    public Result addAll(List<University> university) {
        this.universityRepository.saveAll(university);
        return new SuccessResult("ok");
    }

    @Override
    public Result delete(University university) {
        this.universityRepository.delete(university);
        return new SuccessResult("ok");
    }

    @Override
    public DataResult<List<University>> findAll() {
        return new SuccessDataResult<List<University>>(this.universityRepository.findAll(),"ok");
    }

    @Override
    public DataResult<University> findById(int id) {
        University university = this.universityRepository.findById(id).orElse(null);
        if(university==null)
            return new ErrorDataResult<University>("no");
        return new SuccessDataResult<University>(university,"ok");
    }

    @Override
    public DataResult<List<University>> findAllByJobSeekerId(int id) {
        return new SuccessDataResult<List<University>>(this.universityRepository.findAllByJobSeekerId(id));
    }
}
