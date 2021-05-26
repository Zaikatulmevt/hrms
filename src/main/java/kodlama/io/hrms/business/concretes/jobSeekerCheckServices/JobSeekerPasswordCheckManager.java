package kodlama.io.hrms.business.concretes.jobSeekerCheckServices;

import kodlama.io.hrms.business.abstracts.JobSeekerCheckService;
import kodlama.io.hrms.core.Utilities.Results.ErrorResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.core.Utilities.Results.SuccessResult;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerPasswordCheckManager implements JobSeekerCheckService {
    @Override
    public Result checkJobSeeker(JobSeeker jobSeeker) {
        if(jobSeeker.getPassword().equals(jobSeeker.getPassword2())){

            return new SuccessResult();
        }
        return new ErrorResult("Password must be same");
    }
}
