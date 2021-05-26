package kodlama.io.hrms.business.concretes.jobSeekerCheckServices;

import kodlama.io.hrms.adapters.abstracts.MernisService;
import kodlama.io.hrms.business.abstracts.JobSeekerCheckService;
import kodlama.io.hrms.core.Utilities.Results.ErrorResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.core.Utilities.Results.SuccessResult;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerMernisCheckManager implements JobSeekerCheckService {

    @Autowired
    private MernisService mernisService;

    @Override
    public Result checkJobSeeker(JobSeeker jobSeeker) {
        if (this.mernisService.checkNationalId(jobSeeker)) {
            return new SuccessResult();
        }
        return new ErrorResult("You're not Turkish citizen.");
    }
}
