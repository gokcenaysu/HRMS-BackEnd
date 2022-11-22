package kodlama.io.hrms.controller;

import kodlama.io.hrms.core.entities.User;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.service.concretes.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public DataResult<List<User>> findAll() {
        return this.service.findAll();
    }

    @GetMapping(value = "/{id}")
    public DataResult<User> findById(int id) {
        return this.service.findById(id);
    }
}
