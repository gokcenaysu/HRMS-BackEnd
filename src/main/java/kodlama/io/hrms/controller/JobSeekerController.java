package kodlama.io.hrms.controller;

import kodlama.io.hrms.service.abstracts.JobSeekerService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.JobSeeker;
import kodlama.io.hrms.model.dtos.CreateResumeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobseeker")
@CrossOrigin
public class JobSeekerController {

    @Autowired
    private JobSeekerService jobSeekerService;
    public JobSeekerController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @GetMapping("/getAll")
    public DataResult<List<JobSeeker>> findAll(){
        return this.jobSeekerService.findAll();
    }

    @GetMapping("/sortedAsc")
    public  DataResult<List<JobSeeker>> findAllSortedAsc(){
        return this.jobSeekerService.findAllSortedAsc();
    }

    @GetMapping(value = "/{id}")
    public DataResult<JobSeeker> findById(int id){
        return this.jobSeekerService.findById(id);
    }

    @PostMapping("/register")
    public Result register(@RequestBody JobSeeker jobSeeker) {
        return this.jobSeekerService.register(jobSeeker);
    }

    @PutMapping("/login")
    public Result login (@RequestBody JobSeeker jobSeeker){
        return this.jobSeekerService.login(jobSeeker);
    }

    @GetMapping("/getResume")
    public DataResult<CreateResumeDto> findResumeById(@RequestParam int id){
        return (this.jobSeekerService.findResumeById(id));
    }

}
