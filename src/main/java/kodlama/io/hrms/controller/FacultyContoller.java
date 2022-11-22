package kodlama.io.hrms.controller;

import kodlama.io.hrms.service.abstracts.FacultyService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculty")
@CrossOrigin
public class FacultyContoller {

    private FacultyService facultyService;

    @Autowired
    public FacultyContoller(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping("/add")
    public Result add (@RequestBody Faculty faculty){
        return this.facultyService.add(faculty);
    }

    @DeleteMapping("/delete")
    public Result delete (@RequestBody Faculty faculty){
        return this.facultyService.delete(faculty);
    }

    @GetMapping(value = "/{id}")
    public DataResult<Faculty> findById (int id){
        return this.facultyService.findById(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<Faculty>> findAll(){
        return this.facultyService.findAll();
    }
}
