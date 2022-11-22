package kodlama.io.hrms.controller;

import kodlama.io.hrms.service.abstracts.PositionService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.Position;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/position")
@CrossOrigin
public class PositionController {

    private final PositionService positionService;


    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Position>> findAll(){
        return this.positionService.findAll();
    }

    @GetMapping(value = "/{id}")
    public DataResult<Position> findById(int id){
        return this.positionService.findById(id);
    }

    @GetMapping("/contains")
    public DataResult<List<Position>> findByPositionContains(String position){
        return this.positionService.findByPositionContains(position);
    }

    @GetMapping("/getAllByPage")
    public DataResult<List<Position>> findAllByPage(int pageNo, int pageSize){
        return this.positionService.findAll(pageNo, pageSize);
    }

    @GetMapping("/sortedAsc")
    public  DataResult<List<Position>> findAllSortedAsc(){
        return this.positionService.findAllSortedAsc();
    }

    @PostMapping("/add")
    public Result add (@RequestBody Position position) {
        return this.positionService.add(position);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody Position position){
        return this.positionService.delete(position);
    }
}
