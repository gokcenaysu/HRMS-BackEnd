package kodlama.io.hrms.service.concretes;

import kodlama.io.hrms.service.abstracts.DepartmentService;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.repository.DepartmentRepository;
import kodlama.io.hrms.model.concretes.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentManager implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentManager(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Result add(Department department) {
        this.departmentRepository.save(department);
        return new SuccessResult("ok");
    }

    @Override
    public Result delete(Department department) {
        this.departmentRepository.delete(department);
        return new SuccessResult("ok");
    }

    @Override
    public DataResult<Department> findById(int id) {
        Department department = this.departmentRepository.findById(id);
        if(department==null)
            return new ErrorDataResult<Department>("no");
        return new SuccessDataResult<Department>("no");
    }

    @Override
    public DataResult<List<Department>> findAll() {
        return new SuccessDataResult<List<Department>>(this.departmentRepository.findAll(),"ok");
    }
}
