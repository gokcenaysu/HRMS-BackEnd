package kodlama.io.hrms.controller;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.Faculty;
import kodlama.io.hrms.service.concretes.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculty")
@CrossOrigin
public class FacultyContoller {

    private final FacultyService service;

    public FacultyContoller(FacultyService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Faculty faculty) {
        return this.service.add(faculty);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody Faculty faculty) {
        return this.service.delete(faculty);
    }

    @GetMapping(value = "/{id}")
    public DataResult<Faculty> findById(int id) {
        return this.service.findById(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<Faculty>> findAll() {
        return this.service.findAll();
    }
}
