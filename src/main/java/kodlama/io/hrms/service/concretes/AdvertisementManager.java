package kodlama.io.hrms.service.concretes;

import kodlama.io.hrms.service.abstracts.AdvertisementService;
import kodlama.io.hrms.service.constants.messages;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.repository.AdvertisementRepository;
import kodlama.io.hrms.model.concretes.Advertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementManager implements AdvertisementService {

    private AdvertisementRepository advertisementRepository;

    @Autowired
    public AdvertisementManager(AdvertisementRepository advertisementRepository) {
        this.advertisementRepository = advertisementRepository;
    }

    @Override
    public Result add(Advertisement advertisement) {
        this.advertisementRepository.save(advertisement);
        return new SuccessResult(messages.added);
    }

    @Override
    public Result remove(int id) {
        Advertisement advertisement = this.advertisementRepository.findById(id);
        if(advertisement==null)
            return new ErrorResult(messages.noData);
        this.advertisementRepository.delete(advertisement);
        return new SuccessResult(messages.deleted);
    }

    @Override
    public DataResult<List<Advertisement>> findAll() {
        return new SuccessDataResult<List<Advertisement>>(this.advertisementRepository.findAll(),messages.listed);
    }

    @Override
    public DataResult<List<Advertisement>> findAllSortedAsc() {
        Sort sort = Sort.by(Sort.Direction.ASC,"openPositionCount");
        return new SuccessDataResult<List<Advertisement>>(this.advertisementRepository.findAll(sort),messages.listed);
    }

    @Override
    public DataResult<Advertisement> findById(int id) {
        Advertisement advertisement = advertisementRepository.findById(id);
        if(advertisement==null)
            return new ErrorDataResult<Advertisement>(messages.noData);
        return new SuccessDataResult<Advertisement>(advertisement,messages.listed);
    }

    @Override
    public DataResult<List<Advertisement>> findByActivityStatus() {
        return new SuccessDataResult<List<Advertisement>>(this.advertisementRepository.findByActivityStatus(true));

    }

    @Override
    public DataResult<List<Advertisement>> findByOrderByCreationDate() {
        return new SuccessDataResult<List<Advertisement>>(this.advertisementRepository.findByOrderByCreationDate());
    }

    @Override
    public DataResult<List<Advertisement>> findByOrderByApplicationDeadline() {
        return new SuccessDataResult<List<Advertisement>>(this.advertisementRepository.findByOrderByApplicationDeadline());
    }

    @Override
    public DataResult<List<Advertisement>> findByActivityStatusAndEmployerId(int employerId) {
        return new SuccessDataResult<List<Advertisement>>(this.advertisementRepository.findByActivityStatusAndEmployerId(true,employerId));
    }


//    private boolean existsAdvertisement(Advertisement advertisement){
//        if(findById(advertisement.getId())==null){
//            return false;
//        }
//        return true;
//    }
}
