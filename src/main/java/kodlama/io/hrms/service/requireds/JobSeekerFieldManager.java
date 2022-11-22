package kodlama.io.hrms.service.requireds;

import kodlama.io.hrms.service.abstracts.FieldService;
import kodlama.io.hrms.service.constants.Messages;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.repository.JobSeekerRepository;
import kodlama.io.hrms.repository.UserRepository;
import kodlama.io.hrms.model.concretes.Employer;
import kodlama.io.hrms.model.concretes.JobSeeker;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerFieldManager implements FieldService<JobSeeker> {

    private final JobSeekerRepository jobSeekerRepository;
    private final UserRepository userRepository;
    private final RegexService regexService;

    public JobSeekerFieldManager(JobSeekerRepository jobSeekerRepository, UserRepository userRepository, RegexService regexService) {
        super();
        this.jobSeekerRepository = jobSeekerRepository;
        this.userRepository = userRepository;
        this.regexService = regexService;
    }

    @Override
    public Result verifyRegister(JobSeeker jobSeeker) {

        if (jobSeeker.getEmail().isEmpty() || jobSeeker.getEmail().isBlank()
                || jobSeeker.getFirstName().isEmpty() || jobSeeker.getFirstName().isBlank()
                || jobSeeker.getLastName().isEmpty() || jobSeeker.getLastName().isBlank()
                || jobSeeker.getPassword().isEmpty() || jobSeeker.getPassword().isBlank())
            return new ErrorResult(Messages.emptyField);


        if (userRepository.existsByEmail(jobSeeker.getEmail()))
            return new ErrorResult(Messages.existsEmail);


        if (!regexService.isEmailFormat(jobSeeker.getEmail()))
            return new ErrorResult(Messages.emailFormat);


        if (jobSeekerRepository.existsByIdentityNumber(jobSeeker.getIdentityNumber()))
            return new ErrorResult(Messages.existsIdentityNumber);


        if (jobSeeker.getFirstName().length() < 2 || jobSeeker.getLastName().length() < 2)
            return new ErrorResult(Messages.letterLength);


        if (!regexService.isBirthYearFormat(jobSeeker.getBirthYear()))
            return new ErrorResult(Messages.birthYearFormat);


        if (!regexService.isPasswordFormat(jobSeeker.getPassword()))
            return new ErrorResult(Messages.passwordFormat);


        jobSeekerRepository.save(jobSeeker);
        return new SuccessResult(Messages.registered);
    }

    @Override
    public Result deleteAccount(JobSeeker jobSeeker) {
        if (!jobSeekerRepository.existsByEmail(jobSeeker.getEmail()))
            return new ErrorDataResult<List<Employer>>(Messages.notEmail);

        if (userRepository.findByPasswordEquals(jobSeeker.getPassword()) == null)
            return new ErrorDataResult<List<Employer>>(Messages.errorPassword);

        this.jobSeekerRepository.delete(jobSeeker);
        return new SuccessResult(Messages.deleted);
    }

    @Override
    public Result verifyLogin(JobSeeker jobSeeker) {
        if (!jobSeekerRepository.existsByEmail(jobSeeker.getEmail()))
            return new ErrorDataResult<List<Employer>>(Messages.notEmail);

        if (userRepository.findByPasswordEquals(jobSeeker.getPassword()) == null)
            return new ErrorDataResult<List<Employer>>(Messages.errorPassword);

        return new SuccessResult(Messages.loggedIn);
    }

}