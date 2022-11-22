package kodlama.io.hrms.service.concretes;

import kodlama.io.hrms.service.abstracts.UserService;
import kodlama.io.hrms.service.constants.messages;
import kodlama.io.hrms.core.entities.User;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Override
//    public DataResult<List<User>> login(User user) {
//
//            if(user.getPassword().isBlank() || user.getPassword().isEmpty()
//            || user.getEmail().isBlank() || user.getEmail().isEmpty()){
//                return new ErrorDataResult<List<User>>(messages.emptyField);
//            }
//
//            if(userDao.existsByEmail(user.getEmail())  == false){
//                return new ErrorDataResult<List<User>>(messages.notEmail);
//            }
//            if(userDao.findByPasswordEquals(user.getPassword()) == null){
//                return new ErrorDataResult<List<User>>(messages.errorPassword);
//            }
//            return new SuccessDataResult<List<User>>(messages.loggedIn);
//        }

//    @Override
//    public Result deleteAccount(User user) {
//
//        if(userDao.existsByEmail(user.getEmail())==false){
//            return new ErrorDataResult<List<User>>(messages.notEmail);
//        }
//        if(userDao.findByPasswordEquals(user.getPassword())==null){
//            return new ErrorDataResult<List<User>>(messages.errorPassword);
//        }
//        this.userDao.delete(user);
//        return new SuccessResult(messages.deleted);
//    }

    @Override
    public DataResult<List<User>> findAll() {
        return new SuccessDataResult<List<User>>(this.userRepository.findAll(), messages.listed);
    }

    @Override
    public DataResult<User> findById(int id) {
        User user = this.userRepository.findById(id);
        if(user==null)
            return new ErrorDataResult<User>(messages.noData);
        return new SuccessDataResult<User>(user,messages.listed);
    }
}

