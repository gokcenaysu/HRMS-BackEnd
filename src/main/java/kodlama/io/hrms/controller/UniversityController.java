package kodlama.io.hrms.controller;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.University;
import kodlama.io.hrms.service.concretes.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/university")
@CrossOrigin
public class UniversityController {

    private final UniversityService service;

    public UniversityController(UniversityService universityService) {
        this.service = universityService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody University university) {
        return this.service.add(university);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody University university) {
        return this.service.delete(university);
    }

    @GetMapping(value = "/{id}")
    public DataResult<University> findById(int id) {
        return this.service.findById(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<University>> findAll() {
        return this.service.findAll();
    }
}
