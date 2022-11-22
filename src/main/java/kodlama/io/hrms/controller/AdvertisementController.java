package kodlama.io.hrms.controller;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.Advertisement;
import kodlama.io.hrms.service.concretes.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/advertisement")
@CrossOrigin
public class AdvertisementController {

    private final AdvertisementService service;

    public AdvertisementController(AdvertisementService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public DataResult<List<Advertisement>> findAll() {
        return this.service.findAll();
    }

    @GetMapping("/sortedAsc")
    public DataResult<List<Advertisement>> findAllSortedAsc() {
        return this.service.findAllSortedAsc();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Advertisement advertisement) {
        return this.service.add(advertisement);
    }

    @DeleteMapping("/delete")
    public Result remove(int id) {
        return this.service.remove(id);
    }

    @GetMapping(value = "/{id}")
    public DataResult<Advertisement> findById(int id) {
        return this.service.findById(id);
    }

    @GetMapping("/getByActivityStatus")
    public DataResult<List<Advertisement>> findByActivityStatus() {
        return this.service.findByActivityStatus();
    }

    @GetMapping("/orderByCreationDate")
    public DataResult<List<Advertisement>> findByOrderByCreationDate() {
        return this.service.findByOrderByCreationDate();
    }

    @GetMapping("/orderByApplicationDeadline")
    public DataResult<List<Advertisement>> findByOrderByApplicationDeadline() {
        return this.service.findByOrderByApplicationDeadline();
    }

    @GetMapping("/getByCompany/{id}")
    public DataResult<List<Advertisement>> findByOrderByEmployer(int employerId) {
        return this.service.findByActivityStatusAndEmployerId(employerId);
    }

}
