package kodlama.io.hrms.core.validation;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RegexService {

    public boolean isEmailFormat(String email) {
        String regex = "^(.+)@(\\S+)$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean isBirthYearFormat(String birthYear) {
        String regex = "(?:19|20)\\d\\d";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(birthYear);
        return matcher.matches();
    }

    public boolean isPasswordFormat(String password) {
        String regex = "^(?=.*[A-Z])(?=.*[\\W])(?=.*[0-9])(?=.*[a-z]).{8,128}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
