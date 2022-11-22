package kodlama.io.hrms.controller;

import kodlama.io.hrms.service.abstracts.AdvertisementService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.Advertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/advertisement")
@CrossOrigin
public class AdvertisementController {

    private AdvertisementService advertisementService;

    @Autowired
    public AdvertisementController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Advertisement>> findAll(){
        return this.advertisementService.findAll();
    }

    @GetMapping("/sortedAsc")
    public  DataResult<List<Advertisement>> findAllSortedAsc(){
        return this.advertisementService.findAllSortedAsc();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Advertisement advertisement){
        return this.advertisementService.add(advertisement);
    }

    @DeleteMapping("/delete")
    public Result remove(int id){
        return this.advertisementService.remove(id);
    }

    @GetMapping(value = "/{id}")
    public DataResult<Advertisement> findById (int id){
        return this.advertisementService.findById(id);
    }

    @GetMapping("/getByActivityStatus")
    public DataResult<List<Advertisement>> findByActivityStatus(){
        return this.advertisementService.findByActivityStatus();
    }

    @GetMapping("/orderByCreationDate")
    public DataResult<List<Advertisement>> findByOrderByCreationDate(){
        return this.advertisementService.findByOrderByCreationDate();
    }

    @GetMapping("/orderByApplicationDeadline")
    public DataResult<List<Advertisement>> findByOrderByApplicationDeadline(){
        return this.advertisementService.findByOrderByApplicationDeadline();
    }

    @GetMapping("/getByCompany/{id}")
    public DataResult<List<Advertisement>> findByOrderByEmployer(int employerId){
        return this.advertisementService.findByActivityStatusAndEmployerId(employerId);
    }

}
