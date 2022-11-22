package kodlama.io.hrms.controller;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.Position;
import kodlama.io.hrms.model.concretes.WorkingTime;
import kodlama.io.hrms.service.abstracts.WorkingTimeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/working-time")
public class WorkingTimeController {

    private final WorkingTimeService workingTimeService;

    public WorkingTimeController(WorkingTimeService workingTimeService) {
        this.workingTimeService = workingTimeService;
    }

    @GetMapping("/getAll")
    public DataResult<List<WorkingTime>> findAll(){
        return this.workingTimeService.findAll();
    }

    @PostMapping("/add")
    public Result add (@RequestBody WorkingTime workingTime) {
        return this.workingTimeService.add(workingTime);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody WorkingTime workingTime){
        return this.workingTimeService.delete(workingTime);
    }
}
