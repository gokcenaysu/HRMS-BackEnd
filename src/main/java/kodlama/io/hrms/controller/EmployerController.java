package kodlama.io.hrms.controller;

import kodlama.io.hrms.service.abstracts.EmployerService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employer")
@CrossOrigin
public class EmployerController {

    private EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Employer>> findAll() {
        return this.employerService.findAll();
    }

    @GetMapping(value = "/{id}")
    public DataResult<Employer> findById(int id){
        return this.employerService.findById(id);
    }

    @PostMapping("/register")
    public Result register(@RequestBody Employer employer) {
        return this.employerService.register(employer);
    }

    @PutMapping("/login")
    public Result login (@RequestBody Employer employer) {
        return this.employerService.login(employer);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody Employer employer){
        return this.employerService.delete(employer);
    }
}
