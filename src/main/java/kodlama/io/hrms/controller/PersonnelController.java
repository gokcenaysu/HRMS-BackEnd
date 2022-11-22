package kodlama.io.hrms.controller;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.Personnel;
import kodlama.io.hrms.service.concretes.PersonnelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personnel")
@CrossOrigin
public class PersonnelController {

    private final PersonnelService service;

    public PersonnelController(PersonnelService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public DataResult<List<Personnel>> findAll() {
        return this.service.findAll();
    }

    @GetMapping(value = "/{id}")
    public DataResult<Personnel> findById(int id) {
        return this.service.findById(id);
    }

    @PostMapping("/login")
    public Result login(@RequestBody Personnel personnel) {
        return this.service.login(personnel);
    }
}
