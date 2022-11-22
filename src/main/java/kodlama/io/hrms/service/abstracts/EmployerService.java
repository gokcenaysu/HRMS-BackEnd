package kodlama.io.hrms.service.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.Employer;

import java.util.List;

public interface EmployerService {

    DataResult<List<Employer>> findAll();
    DataResult<Employer> findById(int id);
    Result register(Employer employer);
    Result login (Employer employer);
    Result delete(Employer employer);
}
