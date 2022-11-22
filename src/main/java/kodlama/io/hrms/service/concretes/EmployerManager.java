package kodlama.io.hrms.service.concretes;

import kodlama.io.hrms.service.abstracts.EmployerService;
import kodlama.io.hrms.service.abstracts.FieldService;
import kodlama.io.hrms.service.constants.messages;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.repository.EmployerRepository;
import kodlama.io.hrms.model.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerRepository employerRepository;
    private FieldService<Employer> fieldService;

    @Autowired
    public EmployerManager(EmployerRepository employerRepository, FieldService<Employer> fieldService) {
        this.employerRepository = employerRepository;
        this.fieldService=fieldService;
    }
    @Override
    public DataResult<List<Employer>> findAll() {
        return new SuccessDataResult<List<Employer>>(this.employerRepository.findAll(),messages.listed);
    }

    @Override
    public DataResult<Employer> findById(int id) {
        Employer employer = employerRepository.findById(id);
        if(employer==null)
            return new ErrorDataResult<Employer>(messages.noData);
        return new SuccessDataResult<Employer>(employer,messages.listed);
    }

    @Override
    public Result register(Employer employer) {
        return this.fieldService.verifyRegister(employer);
    }

    @Override
    public Result login(Employer employer) {
        return this.fieldService.verifyLogin(employer);
    }

    @Override
    public Result delete(Employer employer) {
       return this.fieldService.deleteAccount(employer);
    }

}
