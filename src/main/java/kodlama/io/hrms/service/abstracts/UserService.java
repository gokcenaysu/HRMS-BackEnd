package kodlama.io.hrms.service.abstracts;

import kodlama.io.hrms.core.entities.User;
import kodlama.io.hrms.core.utilities.results.DataResult;

import java.util.List;

public interface UserService {

//    DataResult<List<User>> login(User user);
//    Result deleteAccount(User user);
    DataResult<List<User>> findAll();
    DataResult<User> findById(int id);
}
