package kodlama.io.hrms.controller;

import kodlama.io.hrms.model.dtos.CreateResumeDto;
import kodlama.io.hrms.service.abstracts.ExperienceService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experience")
@CrossOrigin
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;

    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @PostMapping("add")
    public Result add (@RequestBody CreateResumeDto createResumeDto){
        return this.experienceService.add(createResumeDto);
    }

    @DeleteMapping("/delete")
    public Result delete (@RequestBody Experience experience){
        return this.experienceService.delete(experience);
    }

    @GetMapping(value = "/{id}")
    public DataResult<Experience> findById (int id){
        return this.experienceService.findById(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<Experience>> findAll(){
        return this.experienceService.findAll();
    }
}
