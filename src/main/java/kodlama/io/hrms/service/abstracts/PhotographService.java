package kodlama.io.hrms.service.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.Photograph;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PhotographService {

    Result add (Photograph photograph);
    Result addPhoto (Photograph photograph, MultipartFile file);
    Result addAll (List<Photograph> photograph);
    Result delete(Photograph photograph);
    DataResult<List<Photograph>> findAll();
    DataResult<Photograph> findById(int id);
    DataResult<List<Photograph>> findAllByJobSeekerId(int id);


}
