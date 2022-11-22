package kodlama.io.hrms.controller;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.JobSeeker;
import kodlama.io.hrms.model.concretes.Photograph;
import kodlama.io.hrms.service.concretes.PhotographService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/photograph")
@CrossOrigin
public class PhotographController {

    private final PhotographService service;

    public PhotographController(PhotographService service) {
        this.service = service;
    }

   /* @PostMapping("add")
    public Result add (@RequestBody Photograph photograph){
        return this.photographService.add(photograph);
    }*/

    @PostMapping("/add")
    public Result add(@RequestPart("file") MultipartFile file, int id) {
        Photograph photograph = new Photograph();
        JobSeeker jobSeeker = new JobSeeker();
        jobSeeker.setId(id);
        photograph.setJobSeeker(jobSeeker);
        return this.service.addPhoto(photograph, file);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody Photograph photograph) {
        return this.service.delete(photograph);
    }

    @GetMapping(value = "/{id}")
    public DataResult<Photograph> findById(int id) {
        return this.service.findById(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<Photograph>> findAll() {
        return this.service.findAll();
    }
}
