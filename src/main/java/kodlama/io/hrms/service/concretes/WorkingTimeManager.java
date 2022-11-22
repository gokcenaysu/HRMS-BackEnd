package kodlama.io.hrms.service.concretes;

import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.model.concretes.Position;
import kodlama.io.hrms.model.concretes.WorkingTime;
import kodlama.io.hrms.repository.WorkingTimeRepository;
import kodlama.io.hrms.service.abstracts.WorkingTimeService;
import kodlama.io.hrms.service.constants.messages;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingTimeManager implements WorkingTimeService {

    private final WorkingTimeRepository workingTimeRepository;

    public WorkingTimeManager(WorkingTimeRepository workingTimeRepository) {
        this.workingTimeRepository = workingTimeRepository;
    }

    @Override
    public Result add(WorkingTime workingTime) {
        this.workingTimeRepository.save(workingTime);
        return new SuccessResult(messages.added);
    }

    @Override
    public Result delete(WorkingTime workingTime) {
        this.workingTimeRepository.delete(workingTime);
        return new SuccessResult(messages.deleted);
    }

    @Override
    public DataResult<List<WorkingTime>> findAll() {
        return new SuccessDataResult<List<WorkingTime>>(this.workingTimeRepository.findAll());
    }

//    @Override
//    public DataResult<WorkingTime> findById(int id) {
//        WorkingTime workingTime = this.workingTimeRepository.findById(id);
//        if(workingTime==null)
//            return new ErrorDataResult<WorkingTime>(messages.noData);
//        return new SuccessDataResult<WorkingTime>(workingTime,messages.listed);
//    }
}
