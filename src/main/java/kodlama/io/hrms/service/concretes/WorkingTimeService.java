package kodlama.io.hrms.service.concretes;

import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.model.concretes.WorkingTime;
import kodlama.io.hrms.repository.WorkingTimeRepository;
import kodlama.io.hrms.service.constants.Messages;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingTimeService {

    private final WorkingTimeRepository repository;

    public WorkingTimeService(WorkingTimeRepository repository) {
        this.repository = repository;
    }

    public Result add(WorkingTime workingTime) {
        this.repository.save(workingTime);
        return new SuccessResult(Messages.added);
    }

    public Result delete(WorkingTime workingTime) {
        this.repository.delete(workingTime);
        return new SuccessResult(Messages.deleted);
    }

    public DataResult<List<WorkingTime>> findAll() {
        return new SuccessDataResult<List<WorkingTime>>(this.repository.findAll());
    }

//    @Override
//    public DataResult<WorkingTime> findById(int id) {
//        WorkingTime workingTime = this.workingTimeRepository.findById(id);
//        if(workingTime==null)
//            return new ErrorDataResult<WorkingTime>(messages.noData);
//        return new SuccessDataResult<WorkingTime>(workingTime,messages.listed);
//    }
}
