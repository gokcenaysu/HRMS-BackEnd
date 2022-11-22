package kodlama.io.hrms.core.validation;

public interface RegexService {

    boolean isEmailFormat(String email);
//  boolean isPhoneNumberFormat(String phoneNumber);
    boolean isBirthYearFormat(String birthYear);
    boolean isPasswordFormat(String password);

}
