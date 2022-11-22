package kodlama.io.hrms.service.concretes;

import kodlama.io.hrms.service.abstracts.*;
import kodlama.io.hrms.service.constants.Messages;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.repository.JobSeekerRepository;
import kodlama.io.hrms.model.concretes.*;
import kodlama.io.hrms.model.dtos.CreateResumeDto;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerService {

    private final JobSeekerRepository repository;
    private final FieldService<JobSeeker> fieldService;
    private final ExperienceService experienceService;
    private final LanguageService languageService;
    private final SkillService skillService;
    private final LinkService linkService;
    private final PhotographService photographService;
    private final UniversityService universityService;
    private final FacultyService facultyService;

    public JobSeekerService(JobSeekerRepository repository, FieldService<JobSeeker> fieldService,
                            ExperienceService experienceService,
                            LanguageService languageService, SkillService skillService,
                            LinkService linkService, PhotographService photographService,
                            UniversityService universityService, FacultyService facultyService) {
        this.repository = repository;
        this.fieldService = fieldService;
        this.experienceService = experienceService;
        this.languageService = languageService;
        this.linkService = linkService;
        this.photographService = photographService;
        this.skillService = skillService;
        this.universityService = universityService;
        this.facultyService = facultyService;
    }

    public DataResult<List<JobSeeker>> findAll() {
        return new SuccessDataResult<List<JobSeeker>>(this.repository.findAll());
    }

    public DataResult<CreateResumeDto> findResumeById(int id) {
        CreateResumeDto createResumeDto = new CreateResumeDto();
        createResumeDto.setJobSeeker(this.findById(id).getData());
        createResumeDto.setExperiences(this.experienceService.findAllByJobSeekerId(id).getData());
        createResumeDto.setUniversities(this.universityService.findAllByJobSeekerId(id).getData());
//        createResumeDto.setFaculties(this.facultyService.findAllByJobSeekerId(id).getData());
        createResumeDto.setLanguages(this.languageService.findAllByJobSeekerId(id).getData());
        createResumeDto.setLinks(this.linkService.findAllByJobSeekerId(id).getData());
        createResumeDto.setPhotographs(this.photographService.findAllByJobSeekerId(id).getData());
        createResumeDto.setSkills(this.skillService.findAllByJobSeekerId(id).getData());

        return new SuccessDataResult<>(createResumeDto, "Listed");
    }

    public DataResult<List<JobSeeker>> findAllSortedAsc() {
        Sort sort = Sort.by(Sort.Direction.ASC, "birthYear");
        return new SuccessDataResult<List<JobSeeker>>(this.repository.findAll(sort), Messages.listed);
    }

    public DataResult<JobSeeker> findById(int id) {
        JobSeeker jobSeeker = this.repository.findById(id);
        if (jobSeeker == null)
            return new ErrorDataResult<JobSeeker>(Messages.noData);
        return new SuccessDataResult<JobSeeker>(jobSeeker, Messages.listed);
    }

    public Result register(JobSeeker jobSeeker) {
        return this.fieldService.verifyRegister(jobSeeker);
    }

    public Result delete(JobSeeker jobSeeker) {
        return this.fieldService.deleteAccount(jobSeeker);
    }

    public Result login(JobSeeker jobSeeker) {
        return this.fieldService.verifyLogin(jobSeeker);
    }
}
