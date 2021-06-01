package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.EmployerCheckService;
import kodlama.io.hrms.business.abstracts.SystemStaffService;
import kodlama.io.hrms.core.Utilities.Results.ErrorResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.core.Utilities.Results.SuccessResult;
import kodlama.io.hrms.core.Utilities.Results.abstracts.EmailValidatorService;
import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.dataAccess.abstracts.UserDao;
import kodlama.io.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerCheckManager implements EmployerCheckService {

    private UserDao userDao;
    private EmailValidatorService emailValidatorService;
    private SystemStaffService systemStaffService;
    @Autowired
    public EmployerCheckManager(UserDao userDao, EmailValidatorService emailValidatorService, SystemStaffService systemStaffService) {
        this.userDao = userDao;
        this.emailValidatorService = emailValidatorService;
        this.systemStaffService = systemStaffService;
    }

    @Override
    public Result checkEmployer(Employer employer) {
        String[] splitMail = employer.getEmail().split("@");
        if (!splitMail[1].equals(employer.getWebSite())) {
            return new ErrorResult("Web site domain and your mail adress should be the same.");
        }
        if (!this.emailValidatorService.checkEmail(employer)) {
            return new ErrorResult("Email could not validated.");
        }
        if (!employer.getPassword().equals(employer.getPassword2())) {
            return new ErrorResult("Passwords should be the same.");
        }
        if (this.userDao.existsByEmail(employer.getEmail())) {
            return new ErrorResult("This email adress is already used, please try another one.");
        }
        if (!this.systemStaffService.validateEmployer()) {
            return new ErrorResult("Admin rejected your request");
        }
        return new SuccessResult();
    }
}
