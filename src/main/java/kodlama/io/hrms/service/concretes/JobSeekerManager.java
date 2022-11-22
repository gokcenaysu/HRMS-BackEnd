package kodlama.io.hrms.service.concretes;

import kodlama.io.hrms.service.abstracts.*;
import kodlama.io.hrms.service.constants.messages;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.repository.JobSeekerRepository;
import kodlama.io.hrms.model.concretes.*;
import kodlama.io.hrms.model.dtos.CreateResumeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

    @Autowired
    private JobSeekerRepository jobSeekerRepository;
    private FieldService<JobSeeker> fieldService;
    private ExperienceService experienceService;
    private LanguageService languageService;
    private SkillService skillService;
    private LinkService linkService;
    private PhotographService photographService;
    private UniversityService universityService;
    private FacultyService facultyService;

    public JobSeekerManager(JobSeekerRepository jobSeekerRepository, FieldService<JobSeeker> fieldService,
                            ExperienceService experienceService,
                            LanguageService languageService, SkillService skillService,
                            LinkService linkService, PhotographService photographService,
                            UniversityService universityService, FacultyService facultyService) {
        this.jobSeekerRepository = jobSeekerRepository;
        this.fieldService = fieldService;
        this.experienceService = experienceService;
        this.languageService = languageService;
        this.linkService = linkService;
        this.photographService = photographService;
        this.skillService = skillService;
        this.universityService =universityService;
        this.facultyService = facultyService;
    }

    @Override
    public DataResult<List<JobSeeker>> findAll() {
        return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerRepository.findAll());
    }

    @Override
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

    @Override
    public DataResult<List<JobSeeker>> findAllSortedAsc() {
        Sort sort = Sort.by(Sort.Direction.ASC,"birthYear");
        return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerRepository.findAll(sort),messages.listed);
    }

    @Override
    public DataResult<JobSeeker> findById(int id) {
        JobSeeker jobSeeker = this.jobSeekerRepository.findById(id);
        if(jobSeeker==null)
            return new ErrorDataResult<JobSeeker>(messages.noData);
        return new SuccessDataResult<JobSeeker>(jobSeeker,messages.listed);
    }

    @Override
    public Result register(JobSeeker jobSeeker) {
        return this.fieldService.verifyRegister(jobSeeker);
    }

    @Override
    public Result delete(JobSeeker jobSeeker) {
        return this.fieldService.deleteAccount(jobSeeker);
    }

    @Override
    public Result login(JobSeeker jobSeeker) {
        return this.fieldService.verifyLogin(jobSeeker);
    }


}
