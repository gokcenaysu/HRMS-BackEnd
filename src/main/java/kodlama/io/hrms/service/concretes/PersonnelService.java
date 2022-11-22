package kodlama.io.hrms.service.concretes;

import kodlama.io.hrms.service.constants.Messages;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.repository.PersonnelRepository;
import kodlama.io.hrms.model.concretes.Personnel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonnelService {

    private final PersonnelRepository repository;

    public PersonnelService(PersonnelRepository repository) {
        this.repository = repository;
    }

    public DataResult<List<Personnel>> findAll() {
        return new SuccessDataResult<List<Personnel>>(this.repository.findAll());
    }

    public DataResult<Personnel> findById(int id) {
        Personnel personnel = this.repository.findById(id);
        if (personnel == null)
            return new ErrorDataResult<Personnel>(Messages.noData);
        return new SuccessDataResult<Personnel>(personnel, Messages.listed);
    }

    public Result login(Personnel personnel) {
        this.repository.save(personnel);
        return new SuccessResult(Messages.loggedIn);
    }
}
