package kodlama.io.hrms.controller;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.JobSeeker;
import kodlama.io.hrms.model.dtos.CreateResumeDto;
import kodlama.io.hrms.service.concretes.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobseeker")
@CrossOrigin
public class JobSeekerController {

    private final JobSeekerService service;

    public JobSeekerController(JobSeekerService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public DataResult<List<JobSeeker>> findAll() {
        return this.service.findAll();
    }

    @GetMapping("/sortedAsc")
    public DataResult<List<JobSeeker>> findAllSortedAsc() {
        return this.service.findAllSortedAsc();
    }

    @GetMapping(value = "/{id}")
    public DataResult<JobSeeker> findById(int id) {
        return this.service.findById(id);
    }

    @PostMapping("/register")
    public Result register(@RequestBody JobSeeker jobSeeker) {
        return this.service.register(jobSeeker);
    }

    @PutMapping("/login")
    public Result login(@RequestBody JobSeeker jobSeeker) {
        return this.service.login(jobSeeker);
    }

    @GetMapping("/getResume")
    public DataResult<CreateResumeDto> findResumeById(@RequestParam int id) {
        return (this.service.findResumeById(id));
    }

}
