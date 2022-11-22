package kodlama.io.hrms.service.concretes;

import kodlama.io.hrms.service.abstracts.FieldService;
import kodlama.io.hrms.service.constants.Messages;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.repository.EmployerRepository;
import kodlama.io.hrms.model.concretes.Employer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerService {

    private final EmployerRepository repository;
    private final FieldService<Employer> fieldService;

    public EmployerService(EmployerRepository repository, FieldService<Employer> fieldService) {
        this.repository = repository;
        this.fieldService = fieldService;
    }

    public DataResult<List<Employer>> findAll() {
        return new SuccessDataResult<List<Employer>>(this.repository.findAll(), Messages.listed);
    }

    public DataResult<Employer> findById(int id) {
        Employer employer = repository.findById(id);
        if (employer == null)
            return new ErrorDataResult<Employer>(Messages.noData);
        return new SuccessDataResult<Employer>(employer, Messages.listed);
    }

    public Result register(Employer employer) {
        return this.fieldService.verifyRegister(employer);
    }

    public Result login(Employer employer) {
        return this.fieldService.verifyLogin(employer);
    }

    public Result delete(Employer employer) {
        return this.fieldService.deleteAccount(employer);
    }

}
