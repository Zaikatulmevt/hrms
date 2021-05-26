package kodlama.io.hrms.business.concretes.EmployerCheckServices;

import kodlama.io.hrms.business.abstracts.EmployerCheckService;
import kodlama.io.hrms.core.Utilities.Results.ErrorResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.core.Utilities.Results.SuccessResult;
import kodlama.io.hrms.entities.concretes.Employer;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmployerWebCheckManager implements EmployerCheckService {
    @Override
    public Result checkEmployer(Employer employer) {
        String[] email = employer.getEmail().split("@");
        String webSite = employer.getWebSite();

        Pattern pattern = Pattern.compile("%s".format(email[1]), Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(webSite);
        boolean matchFound = matcher.find();

        if (!matchFound) {
            return new ErrorResult("Web site domain and your mail adress should be the same.");
        }
        return new SuccessResult();
    }
}
