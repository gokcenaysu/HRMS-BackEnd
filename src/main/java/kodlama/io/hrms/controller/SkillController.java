package kodlama.io.hrms.controller;

import kodlama.io.hrms.model.dtos.CreateResumeDto;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.Skill;
import kodlama.io.hrms.service.concretes.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ap/skill")
@CrossOrigin
public class SkillController {

    private final SkillService service;

    public SkillController(SkillService service) {
        this.service = service;
    }


    @PostMapping("add")
    public Result add(@RequestBody CreateResumeDto createResumeDto) {
        return this.service.add(createResumeDto);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody Skill skill) {
        return this.service.delete(skill);
    }

    @GetMapping(value = "/{id}")
    public DataResult<Skill> findById(int id) {
        return this.service.findById(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<Skill>> findAll() {
        return this.service.findAll();
    }
}
