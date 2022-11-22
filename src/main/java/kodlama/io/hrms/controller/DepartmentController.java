package kodlama.io.hrms.controller;

import kodlama.io.hrms.service.abstracts.DepartmentService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
@CrossOrigin
public class DepartmentController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/add")
    public Result add (@RequestBody Department department){
        return this.departmentService.add(department);
    }

    @DeleteMapping("/delete")
    public Result delete (@RequestBody Department department){
        return this.departmentService.delete(department);
    }

    @GetMapping(value = "/{id}")
    public DataResult<Department> findById (int id){
        return this.departmentService.findById(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<Department>> findAll(){
        return this.departmentService.findAll();
    }
}
