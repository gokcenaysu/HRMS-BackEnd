package kodlama.io.hrms.controller;

import kodlama.io.hrms.service.abstracts.UserService;
import kodlama.io.hrms.core.entities.User;
import kodlama.io.hrms.core.utilities.results.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public DataResult<List<User>> findAll(){
        return this.userService.findAll();
    }

    @GetMapping(value = "/{id}")
    public DataResult<User> findById(int id){
        return this.userService.findById(id);
    }
}
