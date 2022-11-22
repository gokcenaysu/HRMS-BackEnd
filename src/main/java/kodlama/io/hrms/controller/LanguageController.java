package kodlama.io.hrms.controller;

import kodlama.io.hrms.model.dtos.CreateResumeDto;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.Language;
import kodlama.io.hrms.service.concretes.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/language")
@CrossOrigin
public class LanguageController {

    private final LanguageService service;

    public LanguageController(LanguageService service) {
        this.service = service;
    }

    @PostMapping("add")
    public Result add(@RequestBody CreateResumeDto createResumeDto) {
        return this.service.add(createResumeDto);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody Language language) {
        return this.service.delete(language);
    }

    @GetMapping(value = "/{id}")
    public DataResult<Language> findById(int id) {
        return this.service.findById(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<Language>> findAll() {
        return this.service.findAll();
    }
}
