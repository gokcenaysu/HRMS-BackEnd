package kodlama.io.hrms.service.concretes;

import kodlama.io.hrms.service.abstracts.CityService;
import kodlama.io.hrms.service.constants.messages;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.repository.CityRepository;
import kodlama.io.hrms.model.concretes.City;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {

    @Autowired
    private CityRepository cityRepository;
    private ModelMapper modelMapper;


    public CityManager(CityRepository cityRepository, ModelMapper modelMapper) {
        this.cityRepository = cityRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result add(City city){
        this.cityRepository.save(city);
        return new SuccessResult("ok");
    }

    @Override
    public Result addAll(List<City> city) {
        this.cityRepository.saveAll(city);
        return new SuccessResult("ok");
    }

    @Override
    public Result delete(City city) {
        this.cityRepository.delete(city);
        return new SuccessResult("ok");
    }

    @Override
    public DataResult<List<City>> findAll() {
        return new SuccessDataResult<List<City>>(this.cityRepository.findAll(),"ok");
    }

    @Override
    public DataResult<City> findById(int id) {
        City city = cityRepository.findById(id);
        if(city==null)
            return new ErrorDataResult<City>(messages.noData);
        return new SuccessDataResult<City>(city,messages.listed);
    }
}
