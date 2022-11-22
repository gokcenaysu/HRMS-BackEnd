package kodlama.io.hrms.service.concretes;

import kodlama.io.hrms.service.abstracts.LanguageService;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.repository.LanguageRepository;
import kodlama.io.hrms.model.concretes.Language;
import kodlama.io.hrms.model.dtos.CreateResumeDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {

    @Autowired
    private LanguageRepository languageRepository;
    private ModelMapper modelMapper;

    public LanguageManager(LanguageRepository languageRepository, ModelMapper modelMapper) {
        this.languageRepository = languageRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result add(CreateResumeDto createResumeDto) {
        Language language = modelMapper.map(createResumeDto, Language.class);
        this.languageRepository.save(language);
        return new SuccessResult("ok");
    }

    @Override
    public Result addAll(List<Language> language) {
        this.languageRepository.saveAll(language);
        return new SuccessResult("ok");
    }

    @Override
    public Result delete(Language language) {
        this.languageRepository.delete(language);
        return new SuccessResult("ok");
    }

    @Override
    public DataResult<List<Language>> findAll() {
        return new SuccessDataResult<List<Language>>(this.languageRepository.findAll(),"ok");
    }

    @Override
    public DataResult<Language> findById(int id) {
        Language language = this.languageRepository.findById(id);
        if(language==null)
            return new ErrorDataResult<Language>("no");
        return new SuccessDataResult<Language>("ok");
    }

    @Override
    public DataResult<List<Language>> findAllByJobSeekerId(int id) {
        return new SuccessDataResult<List<Language>>(this.languageRepository.findAllByJobSeekerId(id));
    }
}
