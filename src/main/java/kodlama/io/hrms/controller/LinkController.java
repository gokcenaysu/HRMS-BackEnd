package kodlama.io.hrms.controller;

import kodlama.io.hrms.model.dtos.CreateResumeDto;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.Link;
import kodlama.io.hrms.service.concretes.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/link")
@CrossOrigin
public class LinkController {

    private final LinkService service;

    public LinkController(LinkService linkService) {
        this.service = linkService;
    }

    @PostMapping("add")
    public Result add(@RequestBody CreateResumeDto createResumeDto) {
        return this.service.add(createResumeDto);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody Link link) {
        return this.service.delete(link);
    }

    @GetMapping(value = "/{id}")
    public DataResult<Link> findById(int id) {
        return this.service.findById(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<Link>> findAll() {
        return this.service.findAll();
    }
}
