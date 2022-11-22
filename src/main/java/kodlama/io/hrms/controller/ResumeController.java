package kodlama.io.hrms.controller;

import kodlama.io.hrms.service.abstracts.ResumeService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.dtos.CreateResumeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resumes/")
@CrossOrigin
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping()
    public Result add (@RequestBody CreateResumeDto createResumeDto, int id){
        return this.resumeService.add(createResumeDto, id);
    }

//    @DeleteMapping("delete")
//    public Result delete (@RequestBody Resume resume){
//        return this.resumeService.delete(resume);
//    }
//
//    @GetMapping("findById")
//    public DataResult<Resume> findById (int id){
//        return this.resumeService.findById(id);
//    }
//
//    @GetMapping("findAll")
//    public DataResult<List<Resume>> findAll( ){
//        return this.resumeService.findAll();
//    }
}
