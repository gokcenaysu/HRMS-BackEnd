package kodlama.io.hrms.controller;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.Position;
import kodlama.io.hrms.service.concretes.PositionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/position")
@CrossOrigin
public class PositionController {

    private final PositionService service;

    public PositionController(PositionService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public DataResult<List<Position>> findAll() {
        return this.service.findAll();
    }

    @GetMapping(value = "/{id}")
    public DataResult<Position> findById(int id) {
        return this.service.findById(id);
    }

    @GetMapping("/contains")
    public DataResult<List<Position>> findByPositionContains(String position) {
        return this.service.findByPositionContains(position);
    }

    @GetMapping("/getAllByPage")
    public DataResult<List<Position>> findAllByPage(int pageNo, int pageSize) {
        return this.service.findAll(pageNo, pageSize);
    }

    @GetMapping("/sortedAsc")
    public DataResult<List<Position>> findAllSortedAsc() {
        return this.service.findAllSortedAsc();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Position position) {
        return this.service.add(position);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody Position position) {
        return this.service.delete(position);
    }
}
