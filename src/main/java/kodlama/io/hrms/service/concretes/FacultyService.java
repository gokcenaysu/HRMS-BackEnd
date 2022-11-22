package kodlama.io.hrms.service.concretes;

import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.repository.FacultyRepository;
import kodlama.io.hrms.model.concretes.Faculty;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {

    private final FacultyRepository repository;
    private final ModelMapper modelMapper;

    public FacultyService(FacultyRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public Result add(Faculty faculty) {
        this.repository.save(faculty);
        return new SuccessResult("ok");
    }

    public Result addAll(List<Faculty> faculty) {
        this.repository.saveAll(faculty);
        return new SuccessResult("ok");
    }

    public Result delete(Faculty faculty) {
        this.repository.delete(faculty);
        return new SuccessResult("ok");
    }

    public DataResult<List<Faculty>> findAll() {
        return new SuccessDataResult<List<Faculty>>(this.repository.findAll(), "ok");
    }

    public DataResult<Faculty> findById(int id) {
        Faculty faculty = this.repository.findById(id);
        if (faculty == null)
            return new ErrorDataResult<Faculty>("no");
        return new SuccessDataResult<Faculty>("ok");
    }

//    @Override
//    public DataResult<List<Faculty>> findAllByJobSeekerId(int id) {
//        return new SuccessDataResult<List<Faculty>>(this.facultyDao.findAllByJobSeekerId(id));
//    }
}
