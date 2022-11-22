package kodlama.io.hrms.controller;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.City;
import kodlama.io.hrms.service.concretes.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
@CrossOrigin
public class CityController {

    private final CityService service;

    public CityController(CityService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public Result add (@RequestBody City city){
        return this.service.add(city);
    }

    @DeleteMapping("/delete")
    public Result delete (@RequestBody City city){
        return this.service.delete(city);
    }

    @GetMapping(value = "/{id}")
    public DataResult<City> findById (int id){
        return this.service.findById(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<City>> findAll(){
        return this.service.findAll();
    }
}
