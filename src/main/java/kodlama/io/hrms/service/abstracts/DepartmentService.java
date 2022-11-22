package kodlama.io.hrms.service.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.Department;

import java.util.List;

public interface DepartmentService {

    Result add (Department department);
    Result delete(Department department);
    DataResult<List<Department>> findAll();
    DataResult<Department> findById(int id);
}
