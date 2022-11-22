package kodlama.io.hrms.service.concretes;

import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.repository.UniversityRepository;
import kodlama.io.hrms.model.concretes.JobSeeker;
import kodlama.io.hrms.model.dtos.CreateResumeDto;
import org.springframework.stereotype.Service;

@Service
public class ResumeService {

    private final ExperienceService experienceService;
    private final UniversityService universityService;
    private final LanguageService languageService;
    private final SkillService skillService;
    private final LinkService linkService;
    private final PhotographService photographService;
    private final JobSeekerService jobSeekerService;
    private final UniversityRepository universityRepository;


    public ResumeService(JobSeekerService jobSeekerService, UniversityRepository universityRepository,
                         ExperienceService experienceService, UniversityService universityService, LanguageService languageService, SkillService skillService, LinkService linkService, PhotographService photographService) {
        this.experienceService = experienceService;
        this.universityService = universityService;
        this.languageService = languageService;
        this.skillService = skillService;
        this.linkService = linkService;
        this.photographService = photographService;
        this.jobSeekerService = jobSeekerService;
        this.universityRepository = universityRepository;
    }


    public Result add(CreateResumeDto createResumeDto, int id) {
        JobSeeker jobSeeker = this.jobSeekerService.findById(id).getData();
        createResumeDto.setJobSeeker(jobSeeker);

//        createResumeDto.getUniversities().forEach(university -> {
//            Optional<University> byId = universityDao.findById(university);
//            byId.ifPresent(university1 -> {
//
//            });
//
//        });

        createResumeDto.getExperiences().forEach(experience -> experience.setJobSeeker(jobSeeker));
        experienceService.addAll(createResumeDto.getExperiences());

        createResumeDto.getLanguages().forEach(language -> language.setJobSeeker(jobSeeker));
        languageService.addAll(createResumeDto.getLanguages());

        createResumeDto.getUniversities().forEach(university -> university.setJobSeeker(jobSeeker));
        universityService.addAll(createResumeDto.getUniversities());

        createResumeDto.getLinks().forEach(link -> link.setJobSeeker(jobSeeker));
        linkService.addAll(createResumeDto.getLinks());

        createResumeDto.getPhotographs().forEach(photograph -> photograph.setJobSeeker(jobSeeker));
        photographService.addAll(createResumeDto.getPhotographs());

        createResumeDto.getSkills().forEach(skill -> skill.setJobSeeker(jobSeeker));
        skillService.addAll(createResumeDto.getSkills());

        return new SuccessResult("ok");
    }

//    @Override
//    public Result delete(Resume resume) {
//        this.resumeDao.delete(resume);
//        return new SuccessResult("ok");
//    }
//
//    @Override
//    public DataResult<List<Resume>> findAll( ) {
//        return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll());
//    }
//
//    @Override
//    public DataResult<Resume> findById(int id) {
//        Resume resume = this.resumeDao.findById(id);
//        if(resume==null)
//            return new ErrorDataResult<Resume>("no");
//        return new SuccessDataResult<Resume>("ok");
//    }
}
