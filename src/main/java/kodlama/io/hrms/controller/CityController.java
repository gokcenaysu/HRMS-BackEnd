package kodlama.io.hrms.controller;

import kodlama.io.hrms.service.abstracts.CityService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
@CrossOrigin
public class CityController {

    private CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/add")
    public Result add (@RequestBody City city){
        return this.cityService.add(city);
    }

    @DeleteMapping("/delete")
    public Result delete (@RequestBody City city){
        return this.cityService.delete(city);
    }

    @GetMapping(value = "/{id}")
    public DataResult<City> findById (int id){
        return this.cityService.findById(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<City>> findAll(){
        return this.cityService.findAll();
    }
}
