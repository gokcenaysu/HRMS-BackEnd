package kodlama.io.hrms.controller;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.WorkingTime;
import kodlama.io.hrms.service.concretes.WorkingTimeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/working-time")
public class WorkingTimeController {

    private final WorkingTimeService service;

    public WorkingTimeController(WorkingTimeService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public DataResult<List<WorkingTime>> findAll(){
        return this.service.findAll();
    }

    @PostMapping("/add")
    public Result add (@RequestBody WorkingTime workingTime) {
        return this.service.add(workingTime);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody WorkingTime workingTime){
        return this.service.delete(workingTime);
    }
}
