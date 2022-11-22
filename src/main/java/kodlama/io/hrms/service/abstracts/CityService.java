package kodlama.io.hrms.service.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.City;

import java.util.List;

public interface CityService {

    Result add (City city);
    Result addAll (List<City> city);
    Result delete(City city);
    DataResult<List<City>> findAll();
    DataResult<City> findById(int id);
}
