package kodlama.io.hrms.controller;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.Department;
import kodlama.io.hrms.service.concretes.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
@CrossOrigin
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Department department) {
        return this.service.add(department);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody Department department) {
        return this.service.delete(department);
    }

    @GetMapping(value = "/{id}")
    public DataResult<Department> findById(int id) {
        return this.service.findById(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<Department>> findAll() {
        return this.service.findAll();
    }
}
