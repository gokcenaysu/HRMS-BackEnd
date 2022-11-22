package kodlama.io.hrms.service.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.model.concretes.Language;
import kodlama.io.hrms.model.dtos.CreateResumeDto;

import java.util.List;

public interface LanguageService {

    Result add (CreateResumeDto createResumeDto);
    Result addAll (List<Language> language);
    Result delete(Language language);
    DataResult<List<Language>> findAll();
    DataResult<Language> findById(int id);
    DataResult<List<Language>> findAllByJobSeekerId(int id);

}
