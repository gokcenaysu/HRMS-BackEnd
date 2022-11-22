package kodlama.io.hrms.controller;

import kodlama.io.hrms.model.dtos.CreateResumeDto;
import kodlama.io.hrms.service.abstracts.LinkService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/link")
@CrossOrigin
public class LinkController {

    private LinkService linkService;

    @Autowired
    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("add")
    public Result add (@RequestBody CreateResumeDto createResumeDto){
        return this.linkService.add(createResumeDto);
    }

    @DeleteMapping("/delete")
    public Result delete (@RequestBody Link link){
        return this.linkService.delete(link);
    }

    @GetMapping(value = "/{id}")
    public DataResult<Link> findById (int id){
        return this.linkService.findById(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<Link>> findAll(){
        return this.linkService.findAll();
    }
}
