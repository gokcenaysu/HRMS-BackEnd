package kodlama.io.hrms.controller;

import kodlama.io.hrms.model.dtos.CreateResumeDto;
import kodlama.io.hrms.service.abstracts.SkillService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ap/programming")
@CrossOrigin
public class ProgrammingController {

    private SkillService skillService;

    @Autowired
    public ProgrammingController(SkillService skillService) {
        this.skillService = skillService;
    }


    @PostMapping("add")
    public Result add (@RequestBody CreateResumeDto createResumeDto){
        return this.skillService.add(createResumeDto);
    }

    @DeleteMapping("/delete")
    public Result delete (@RequestBody Skill skill){
        return this.skillService.delete(skill);
    }

    @GetMapping(value = "/{id}")
    public DataResult<Skill> findById (int id){
        return this.skillService.findById(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<Skill>> findAll(){
        return this.skillService.findAll();
    }
}
