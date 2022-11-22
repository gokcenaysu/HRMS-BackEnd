package kodlama.io.hrms.service.concretes;

import kodlama.io.hrms.service.constants.Messages;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.repository.AdvertisementRepository;
import kodlama.io.hrms.model.concretes.Advertisement;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementService {

    private final AdvertisementRepository repository;

    public AdvertisementService(AdvertisementRepository repository) {
        this.repository = repository;
    }

    public Result add(Advertisement advertisement) {
        this.repository.save(advertisement);
        return new SuccessResult(Messages.added);
    }

    public Result remove(int id) {
        Advertisement advertisement = this.repository.findById(id);
        if (advertisement == null)
            return new ErrorResult(Messages.noData);
        this.repository.delete(advertisement);
        return new SuccessResult(Messages.deleted);
    }

    public DataResult<List<Advertisement>> findAll() {
        return new SuccessDataResult<List<Advertisement>>(this.repository.findAll(), Messages.listed);
    }

    public DataResult<List<Advertisement>> findAllSortedAsc() {
        Sort sort = Sort.by(Sort.Direction.ASC, "openPositionCount");
        return new SuccessDataResult<List<Advertisement>>(this.repository.findAll(sort), Messages.listed);
    }

    public DataResult<Advertisement> findById(int id) {
        Advertisement advertisement = repository.findById(id);
        if (advertisement == null)
            return new ErrorDataResult<Advertisement>(Messages.noData);
        return new SuccessDataResult<Advertisement>(advertisement, Messages.listed);
    }

    public DataResult<List<Advertisement>> findByActivityStatus() {
        return new SuccessDataResult<List<Advertisement>>(this.repository.findByActivityStatus(true));

    }

    public DataResult<List<Advertisement>> findByOrderByCreationDate() {
        return new SuccessDataResult<List<Advertisement>>(this.repository.findByOrderByCreationDate());
    }

    public DataResult<List<Advertisement>> findByOrderByApplicationDeadline() {
        return new SuccessDataResult<List<Advertisement>>(this.repository.findByOrderByApplicationDeadline());
    }

    public DataResult<List<Advertisement>> findByActivityStatusAndEmployerId(int employerId) {
        return new SuccessDataResult<List<Advertisement>>(this.repository.findByActivityStatusAndEmployerId(true, employerId));
    }


//    private boolean existsAdvertisement(Advertisement advertisement){
//        if(findById(advertisement.getId())==null){
//            return false;
//        }
//        return true;
//    }
}
