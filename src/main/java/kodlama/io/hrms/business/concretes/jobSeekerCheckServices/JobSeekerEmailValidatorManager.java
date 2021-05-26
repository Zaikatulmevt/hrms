package kodlama.io.hrms.business.concretes.jobSeekerCheckServices;

import kodlama.io.hrms.business.abstracts.JobSeekerCheckService;
import kodlama.io.hrms.business.abstracts.JobSeekerService;
import kodlama.io.hrms.core.Utilities.Results.ErrorResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.core.Utilities.Results.SuccessResult;
import kodlama.io.hrms.core.Utilities.Results.abstracts.EmailValidatorService;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerEmailValidatorManager implements JobSeekerCheckService {
    @Autowired
    private EmailValidatorService emailValidatorService;

    @Override
    public Result checkJobSeeker(JobSeeker jobSeeker) {
        if (!this.emailValidatorService.checkEmail(jobSeeker)) {
            return new ErrorResult("Email could not validate");
        }
        return new SuccessResult();
    }
}
