package kodlama.io.hrms.service.concretes;

import kodlama.io.hrms.service.constants.Messages;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.repository.CityRepository;
import kodlama.io.hrms.model.concretes.City;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository repository;
    private final ModelMapper modelMapper;


    public CityService(CityRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public Result add(City city) {
        this.repository.save(city);
        return new SuccessResult("ok");
    }

    public Result addAll(List<City> city) {
        this.repository.saveAll(city);
        return new SuccessResult("ok");
    }

    public Result delete(City city) {
        this.repository.delete(city);
        return new SuccessResult("ok");
    }

    public DataResult<List<City>> findAll() {
        return new SuccessDataResult<List<City>>(this.repository.findAll(), "ok");
    }

    public DataResult<City> findById(int id) {
        City city = repository.findById(id);
        if (city == null)
            return new ErrorDataResult<City>(Messages.noData);
        return new SuccessDataResult<City>(city, Messages.listed);
    }
}
