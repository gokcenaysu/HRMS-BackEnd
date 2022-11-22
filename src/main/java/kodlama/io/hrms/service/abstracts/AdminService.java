package kodlama.io.hrms.service.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.Admin;

import java.util.List;

public interface AdminService {

    DataResult<List<Admin>> findAll();
    DataResult<Admin> findById(int id);

    Result login (Admin admin);
}
