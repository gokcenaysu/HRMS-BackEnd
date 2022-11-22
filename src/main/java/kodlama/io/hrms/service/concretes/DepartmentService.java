package kodlama.io.hrms.service.concretes;

import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.repository.DepartmentRepository;
import kodlama.io.hrms.model.concretes.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public Result add(Department department) {
        this.repository.save(department);
        return new SuccessResult("ok");
    }

    public Result delete(Department department) {
        this.repository.delete(department);
        return new SuccessResult("ok");
    }

    public DataResult<Department> findById(int id) {
        Department department = this.repository.findById(id);
        if (department == null)
            return new ErrorDataResult<Department>("no");
        return new SuccessDataResult<Department>("no");
    }

    public DataResult<List<Department>> findAll() {
        return new SuccessDataResult<List<Department>>(this.repository.findAll(), "ok");
    }
}
