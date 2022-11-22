package kodlama.io.hrms.controller;

import kodlama.io.hrms.model.dtos.CreateResumeDto;
import kodlama.io.hrms.service.abstracts.LanguageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/language")
@CrossOrigin
public class LanguageController {

    private LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping("add")
    public Result add (@RequestBody CreateResumeDto createResumeDto){
        return this.languageService.add(createResumeDto);
    }

    @DeleteMapping("/delete")
    public Result delete (@RequestBody Language language){
        return this.languageService.delete(language);
    }

    @GetMapping(value = "/{id}")
    public DataResult<Language> findById (int id){
        return this.languageService.findById(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<Language>> findAll(){
        return this.languageService.findAll();
    }
}
