package kodlama.io.hrms.service.requireds;

import kodlama.io.hrms.service.abstracts.FieldService;
import kodlama.io.hrms.service.constants.messages;
import kodlama.io.hrms.core.validation.RegexService;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.repository.JobSeekerRepository;
import kodlama.io.hrms.repository.UserRepository;
import kodlama.io.hrms.model.concretes.Employer;
import kodlama.io.hrms.model.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerFieldManager implements FieldService<JobSeeker> {

    private JobSeekerRepository jobSeekerRepository;
    private UserRepository userRepository;
    private RegexService regexService;

    @Autowired
    public JobSeekerFieldManager(JobSeekerRepository jobSeekerRepository, UserRepository userRepository, RegexService regexService) {
        super();
        this.jobSeekerRepository = jobSeekerRepository;
        this.userRepository = userRepository;
        this.regexService=regexService;
    }

    @Override
    public Result verifyRegister(JobSeeker jobSeeker) {

        if(jobSeeker.getEmail().isEmpty() || jobSeeker.getEmail().isBlank()
                || jobSeeker.getFirstName().isEmpty() || jobSeeker.getFirstName().isBlank()
                || jobSeeker.getLastName().isEmpty() || jobSeeker.getLastName().isBlank()
                || jobSeeker.getPassword().isEmpty() || jobSeeker.getPassword().isBlank())
            return new ErrorResult(messages.emptyField);


        if(userRepository.existsByEmail(jobSeeker.getEmail()))
            return new ErrorResult(messages.existsEmail);


        if(!regexService.isEmailFormat(jobSeeker.getEmail()))
            return new ErrorResult(messages.emailFormat);


        if(jobSeekerRepository.existsByIdentityNumber(jobSeeker.getIdentityNumber()))
            return new ErrorResult(messages.existsIdentityNumber);


        if(jobSeeker.getFirstName().length()<2 || jobSeeker.getLastName().length()<2)
            return new ErrorResult(messages.letterLength);


        if(!regexService.isBirthYearFormat(jobSeeker.getBirthYear()))
            return new ErrorResult(messages.birthYearFormat);


        if(!regexService.isPasswordFormat(jobSeeker.getPassword()))
            return new ErrorResult(messages.passwordFormat);


        jobSeekerRepository.save(jobSeeker);
        return new SuccessResult(messages.registered);
    }

    @Override
    public Result deleteAccount(JobSeeker jobSeeker) {
        if(!jobSeekerRepository.existsByEmail(jobSeeker.getEmail()))
            return new ErrorDataResult<List<Employer>>(messages.notEmail);

        if(userRepository.findByPasswordEquals(jobSeeker.getPassword())==null)
            return new ErrorDataResult<List<Employer>>(messages.errorPassword);

        this.jobSeekerRepository.delete(jobSeeker);
        return new SuccessResult(messages.deleted);
    }

    @Override
    public Result verifyLogin(JobSeeker jobSeeker) {
        if(!jobSeekerRepository.existsByEmail(jobSeeker.getEmail()))
            return new ErrorDataResult<List<Employer>>(messages.notEmail);

        if(userRepository.findByPasswordEquals(jobSeeker.getPassword())==null)
            return new ErrorDataResult<List<Employer>>(messages.errorPassword);

        return new SuccessResult(messages.loggedIn);
    }

}