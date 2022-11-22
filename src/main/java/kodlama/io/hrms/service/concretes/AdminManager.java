package kodlama.io.hrms.service.concretes;

import kodlama.io.hrms.service.abstracts.AdminService;
import kodlama.io.hrms.service.constants.messages;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.repository.AdminRepository;
import kodlama.io.hrms.model.concretes.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminManager implements AdminService {

    private AdminRepository adminRepository;

    @Autowired
    public AdminManager(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public DataResult<List<Admin>> findAll() {
        return new SuccessDataResult<List<Admin>>(this.adminRepository.findAll());
    }

    @Override
    public DataResult<Admin> findById(int id) {
        Admin admin = this.adminRepository.findById(id);
        if(admin ==null)
            return new ErrorDataResult<Admin>(messages.noData);
        return new SuccessDataResult<Admin>(admin,messages.listed);
    }

    @Override
    public Result login(Admin admin) {
        this.adminRepository.save(admin);
        return new SuccessResult(messages.loggedIn);
    }
}
