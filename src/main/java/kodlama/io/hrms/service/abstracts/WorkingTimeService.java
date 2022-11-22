package kodlama.io.hrms.service.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.University;
import kodlama.io.hrms.model.concretes.WorkingTime;

import java.util.List;

public interface WorkingTimeService {

    Result add  (WorkingTime workingTime);
    Result delete(WorkingTime workingTime);
    DataResult<List<WorkingTime>> findAll();
//    DataResult<WorkingTime> findById(int id);
}
