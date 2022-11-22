package kodlama.io.hrms.service.concretes;

import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.repository.LanguageRepository;
import kodlama.io.hrms.model.concretes.Language;
import kodlama.io.hrms.model.dtos.CreateResumeDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {

    private final LanguageRepository repository;
    private final ModelMapper modelMapper;

    public LanguageService(LanguageRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public Result add(CreateResumeDto createResumeDto) {
        Language language = modelMapper.map(createResumeDto, Language.class);
        this.repository.save(language);
        return new SuccessResult("ok");
    }

    public Result addAll(List<Language> language) {
        this.repository.saveAll(language);
        return new SuccessResult("ok");
    }

    public Result delete(Language language) {
        this.repository.delete(language);
        return new SuccessResult("ok");
    }

    public DataResult<List<Language>> findAll() {
        return new SuccessDataResult<List<Language>>(this.repository.findAll(), "ok");
    }

    public DataResult<Language> findById(int id) {
        Language language = this.repository.findById(id);
        if (language == null)
            return new ErrorDataResult<Language>("no");
        return new SuccessDataResult<Language>("ok");
    }

    public DataResult<List<Language>> findAllByJobSeekerId(int id) {
        return new SuccessDataResult<List<Language>>(this.repository.findAllByJobSeekerId(id));
    }
}
