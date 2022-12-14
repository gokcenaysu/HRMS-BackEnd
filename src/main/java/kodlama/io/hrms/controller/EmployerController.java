package kodlama.io.hrms.controller;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.Employer;
import kodlama.io.hrms.service.concretes.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employer")
@CrossOrigin
public class EmployerController {

    private final EmployerService service;

    public EmployerController(EmployerService employerService) {
        this.service = employerService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Employer>> findAll() {
        return this.service.findAll();
    }

    @GetMapping(value = "/{id}")
    public DataResult<Employer> findById(int id) {
        return this.service.findById(id);
    }

    @PostMapping("/register")
    public Result register(@RequestBody Employer employer) {
        return this.service.register(employer);
    }

    @PutMapping("/login")
    public Result login(@RequestBody Employer employer) {
        return this.service.login(employer);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody Employer employer) {
        return this.service.delete(employer);
    }
}
