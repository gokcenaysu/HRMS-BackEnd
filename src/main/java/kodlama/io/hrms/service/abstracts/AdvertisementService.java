package kodlama.io.hrms.service.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.Advertisement;

import java.util.List;

public interface AdvertisementService {

    Result add(Advertisement advertisement);
    Result remove(int id);
    DataResult<List<Advertisement>> findAll();
    DataResult<List<Advertisement>> findAllSortedAsc();

    DataResult<Advertisement> findById(int id);
    DataResult<List<Advertisement>> findByActivityStatus();
    DataResult<List<Advertisement>> findByOrderByCreationDate();
    DataResult<List<Advertisement>> findByOrderByApplicationDeadline();
    DataResult<List<Advertisement>> findByActivityStatusAndEmployerId(int employerId);

}
