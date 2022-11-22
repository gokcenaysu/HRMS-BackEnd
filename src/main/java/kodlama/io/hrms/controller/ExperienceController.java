package kodlama.io.hrms.controller;

import kodlama.io.hrms.model.dtos.CreateResumeDto;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.Experience;
import kodlama.io.hrms.service.concretes.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experience")
@CrossOrigin
public class ExperienceController {

    private final ExperienceService service;

    public ExperienceController(ExperienceService service) {
        this.service = service;
    }

    @PostMapping("add")
    public Result add (@RequestBody CreateResumeDto createResumeDto){
        return this.service.add(createResumeDto);
    }

    @DeleteMapping("/delete")
    public Result delete (@RequestBody Experience experience){
        return this.service.delete(experience);
    }

    @GetMapping(value = "/{id}")
    public DataResult<Experience> findById (int id){
        return this.service.findById(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<Experience>> findAll(){
        return this.service.findAll();
    }
}
