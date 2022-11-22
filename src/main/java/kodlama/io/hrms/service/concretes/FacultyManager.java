package kodlama.io.hrms.service.concretes;

import kodlama.io.hrms.service.abstracts.FacultyService;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.repository.FacultyRepository;
import kodlama.io.hrms.model.concretes.Faculty;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyManager implements FacultyService {

    private FacultyRepository facultyRepository;
    private ModelMapper modelMapper;

    @Autowired
    public FacultyManager(FacultyRepository facultyRepository, ModelMapper modelMapper) {
        this.facultyRepository = facultyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result add(Faculty faculty) {
            this.facultyRepository.save(faculty);
            return new SuccessResult("ok");
        }

    @Override
    public Result addAll(List<Faculty> faculty) {
        this.facultyRepository.saveAll(faculty);
        return new SuccessResult("ok");
    }

    @Override
    public Result delete(Faculty faculty) {
        this.facultyRepository.delete(faculty);
        return new SuccessResult("ok");
    }

    @Override
    public DataResult<List<Faculty>> findAll() {
        return new SuccessDataResult<List<Faculty>>(this.facultyRepository.findAll(),"ok");
    }

    @Override
    public DataResult<Faculty> findById(int id) {
        Faculty faculty = this.facultyRepository.findById(id);
        if(faculty==null)
            return new ErrorDataResult<Faculty>("no");
        return new SuccessDataResult<Faculty>("ok");
    }

//    @Override
//    public DataResult<List<Faculty>> findAllByJobSeekerId(int id) {
//        return new SuccessDataResult<List<Faculty>>(this.facultyDao.findAllByJobSeekerId(id));
//    }
}
