package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.adapters.abstracts.MernisService;
import kodlama.io.hrms.business.abstracts.JobSeekerCheckService;
import kodlama.io.hrms.core.Utilities.Results.ErrorResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.core.Utilities.Results.SuccessResult;
import kodlama.io.hrms.core.Utilities.Results.abstracts.EmailValidatorService;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlama.io.hrms.dataAccess.abstracts.UserDao;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerCheckManager implements JobSeekerCheckService {

    private JobSeekerDao jobSeekerDao;
    private UserDao userDao;
    private MernisService mernisService;
    private EmailValidatorService emailValidatorService;

    @Autowired
    public JobSeekerCheckManager(JobSeekerDao jobSeekerDao, UserDao userDao, MernisService mernisService, EmailValidatorService emailValidatorService) {
        this.jobSeekerDao = jobSeekerDao;
        this.userDao = userDao;
        this.mernisService = mernisService;
        this.emailValidatorService = emailValidatorService;
    }

    @Override
    public Result checkJobSeeker(JobSeeker jobSeeker) {
        if (!this.emailValidatorService.checkEmail(jobSeeker)) {
            return new ErrorResult("Email could not validated.");
        }
        if (!this.mernisService.checkNationalId(jobSeeker)) {
            return new ErrorResult("You're not Turkish citizen.");
        }
        if (this.jobSeekerDao.existsByNationalityId(jobSeeker.getNationalityId())) {
            return new ErrorResult("This national id is used before, please try another one.");
        }
        if (!jobSeeker.getPassword().equals(jobSeeker.getPassword2())) {
            return new ErrorResult("Password should be the same.");
        }
        if (this.userDao.existsByEmail(jobSeeker.getEmail())) {
            return new ErrorResult("This email is used before. Please try another one.");
        }
        return new SuccessResult();
    }
}
