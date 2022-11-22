package kodlama.io.hrms.service.concretes;

import kodlama.io.hrms.core.imageUploaders.ImageService;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.repository.PhotographRepository;
import kodlama.io.hrms.model.concretes.Photograph;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class PhotographService {

    private final PhotographRepository repository;
    private final ModelMapper modelMapper;
    private final ImageService imageService;

    public PhotographService(PhotographRepository repository, ModelMapper modelMapper,
                             ImageService imageService) {
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.imageService = imageService;
    }

    public Result add(Photograph photograph) {
        // Photograph photograph = modelMapper.map(createResumeDto, Photograph.class);
        this.repository.save(photograph);
        return new SuccessResult("ok");
    }

    public Result addPhoto(Photograph photograph, MultipartFile file) {
        Map<String, String> result = (Map<String, String>) imageService.save(file).getData();
        String url = result.get("url");
        photograph.setPhoto(url);
        photograph.setCreatedOn(LocalDateTime.now());
        return add(photograph);
    }


    public Result addAll(List<Photograph> photograph) {
        this.repository.saveAll(photograph);
        return new SuccessResult("ok");
    }

    public Result delete(Photograph photograph) {
        this.repository.delete(photograph);
        return new SuccessResult("ok");
    }

    public DataResult<List<Photograph>> findAll() {
        return new SuccessDataResult<List<Photograph>>(this.repository.findAll(), "ok");
    }

    public DataResult<Photograph> findById(int id) {
        Photograph photograph = this.repository.findById(id);
        if (photograph == null)
            return new ErrorDataResult<Photograph>("no");
        return new SuccessDataResult<Photograph>("ok");
    }

    public DataResult<List<Photograph>> findAllByJobSeekerId(int id) {
        return new SuccessDataResult<List<Photograph>>(this.repository.findAllByJobSeekerId(id));
    }
}
