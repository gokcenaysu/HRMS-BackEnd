package kodlama.io.hrms.service.concretes;

import kodlama.io.hrms.service.abstracts.PhotographService;
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
public class PhotographManager implements PhotographService {

    @Autowired
    private PhotographRepository photographRepository;
    private ModelMapper modelMapper;
    private ImageService imageService;

    @Autowired
    public PhotographManager(PhotographRepository photographRepository, ModelMapper modelMapper,
                             ImageService imageService) {
        this.photographRepository = photographRepository;
        this.modelMapper = modelMapper;
        this.imageService = imageService;
    }

    @Override
    public Result add(Photograph photograph) {
       // Photograph photograph = modelMapper.map(createResumeDto, Photograph.class);
        this.photographRepository.save(photograph);
        return new SuccessResult("ok");
    }

    @Override
    public Result addPhoto(Photograph photograph, MultipartFile file) {
        Map<String, String> result = (Map<String, String>) imageService.save(file).getData();
        String url = result.get("url");
        photograph.setPhoto(url);
        photograph.setCreatedOn(LocalDateTime.now());
        return add(photograph);
    }


    @Override
    public Result addAll(List<Photograph> photograph) {
        this.photographRepository.saveAll(photograph);
        return new SuccessResult("ok");
    }

    @Override
    public Result delete(Photograph photograph) {
        this.photographRepository.delete(photograph);
        return new SuccessResult("ok");
    }

    @Override
    public DataResult<List<Photograph>> findAll() {
        return new SuccessDataResult<List<Photograph>>(this.photographRepository.findAll(),"ok");
    }

    @Override
    public DataResult<Photograph> findById(int id) {
        Photograph photograph = this.photographRepository.findById(id);
        if(photograph==null)
            return new ErrorDataResult<Photograph>("no");
        return new SuccessDataResult<Photograph>("ok");
    }

    @Override
    public DataResult<List<Photograph>> findAllByJobSeekerId(int id) {
        return new SuccessDataResult<List<Photograph>>(this.photographRepository.findAllByJobSeekerId(id));
    }
}
