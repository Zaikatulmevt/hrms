package kodlama.io.hrms.business.concretes.EmployerCheckServices;

import kodlama.io.hrms.business.abstracts.EmployerCheckService;
import kodlama.io.hrms.core.Utilities.Results.ErrorResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.core.Utilities.Results.SuccessResult;
import kodlama.io.hrms.core.Utilities.Results.abstracts.EmailValidatorService;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.User;
import org.apache.catalina.webresources.ExtractingRoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerEmailValidatorCheckManager implements EmployerCheckService {
    @Autowired
    private EmailValidatorService emailValidatorService;

    @Override
    public Result checkEmployer(Employer employer) {
        if (!this.emailValidatorService.checkEmail(employer)) {
            return new ErrorResult("Email could not validate");
        }
        return new SuccessResult();
    }
}


