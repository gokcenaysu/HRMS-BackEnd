package kodlama.io.hrms.service.requireds;

import kodlama.io.hrms.service.abstracts.FieldService;
import kodlama.io.hrms.service.constants.Messages;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.repository.EmployerRepository;
import kodlama.io.hrms.repository.UserRepository;
import kodlama.io.hrms.model.concretes.Employer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerFieldManager implements FieldService<Employer> {

    private final EmployerRepository employerRepository;
    private final UserRepository userRepository;
    private final RegexService regexService;

    public EmployerFieldManager(EmployerRepository employerRepository, UserRepository userRepository, RegexService regexService) {
        this.employerRepository = employerRepository;
        this.userRepository = userRepository;
        this.regexService = regexService;
    }

    @Override
    public Result verifyRegister(Employer employer) {

        if (employer.getEmail().isEmpty() || employer.getEmail().isBlank()
                || employer.getWebsite().isEmpty() || employer.getWebsite().isBlank()
                || employer.getCompany().isEmpty() || employer.getCompany().isBlank()
                || employer.getPhoneNumber().isEmpty() || employer.getPhoneNumber().isBlank()) {
            return new ErrorResult(Messages.emptyField);
        }

        if (!regexService.isEmailFormat(employer.getEmail())) {
            return new ErrorResult(Messages.emailFormat);
        }

        String email = employer.getEmail();
        String[] emailSplit = email.split("@");
        if (!emailSplit[1].equals(employer.getWebsite()))
            return new ErrorResult("Your e-mail address and domain do not match");

        if (userRepository.existsByEmail(employer.getEmail()))
            return new ErrorResult(Messages.existsEmail);

        if (!regexService.isPasswordFormat(employer.getPassword()))
            return new ErrorResult(Messages.passwordFormat);

        this.employerRepository.save(employer);
        return new SuccessResult(Messages.registered);
    }


    @Override
    public Result deleteAccount(Employer employer) {
        if (!employerRepository.existsByEmail(employer.getEmail()))
            return new ErrorDataResult<List<Employer>>(Messages.notEmail);

        if (employerRepository.findByPasswordEquals(employer.getPassword()) == null)
            return new ErrorDataResult<List<Employer>>(Messages.errorPassword);

        this.employerRepository.delete(employer);
        return new SuccessResult(Messages.deleted);
    }

    @Override
    public Result verifyLogin(Employer employer) {
        if (!employerRepository.existsByEmail(employer.getEmail()))
            return new ErrorDataResult<List<Employer>>(Messages.notEmail);

        if (employerRepository.findByPasswordEquals(employer.getPassword()) == null)
            return new ErrorDataResult<List<Employer>>(Messages.errorPassword);

        return new SuccessResult(Messages.loggedIn);
    }
}

