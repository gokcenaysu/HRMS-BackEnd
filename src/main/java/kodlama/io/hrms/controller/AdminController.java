package kodlama.io.hrms.controller;

import kodlama.io.hrms.service.abstracts.AdminService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController {

    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        super();
        this.adminService = adminService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Admin>> findAll(){
        return this.adminService.findAll();
    }

    @GetMapping(value = "/{id}")
    public DataResult<Admin> findById(int id){
        return this.adminService.findById(id);
    }

    @PostMapping("/login")
    public Result login (@RequestBody Admin admin){
        return this.adminService.login(admin);
    }
}
