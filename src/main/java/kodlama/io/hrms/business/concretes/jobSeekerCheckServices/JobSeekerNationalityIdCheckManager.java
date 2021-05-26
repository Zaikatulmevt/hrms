package kodlama.io.hrms.business.concretes.jobSeekerCheckServices;

import kodlama.io.hrms.business.abstracts.JobSeekerCheckService;
import kodlama.io.hrms.core.Utilities.Results.ErrorResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.core.Utilities.Results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerNationalityIdCheckManager implements JobSeekerCheckService {

    @Autowired
    JobSeekerDao jobSeekerDao;

    @Override
    public Result checkJobSeeker(JobSeeker jobSeeker) {
        if(this.jobSeekerDao.existsByNationalityId(jobSeeker.getNationalityId())){
            return new ErrorResult("Nationality Id Already Exists");
        }
        return new SuccessResult();
    }
}
