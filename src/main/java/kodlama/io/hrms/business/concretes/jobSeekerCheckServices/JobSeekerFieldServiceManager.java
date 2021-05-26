package kodlama.io.hrms.business.concretes.jobSeekerCheckServices;

import kodlama.io.hrms.business.abstracts.JobSeekerCheckService;
import kodlama.io.hrms.business.abstracts.JobSeekerService;
import kodlama.io.hrms.core.Utilities.Results.ErrorResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.core.Utilities.Results.SuccessResult;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerFieldServiceManager implements JobSeekerCheckService {
    @Override
    public Result checkJobSeeker(JobSeeker jobSeeker) {
        if (jobSeeker.getFirstName().isEmpty() || jobSeeker.getLastName().isEmpty() || jobSeeker.getNationalityId().isEmpty()
        || String.valueOf(jobSeeker.getBirthday().getYear()).isEmpty() || jobSeeker.getEmail().isEmpty() ||
                jobSeeker.getPassword().isEmpty()) {
            return new ErrorResult("You have too fill all of slots");
        }

        return new SuccessResult();
    }
}
