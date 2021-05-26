package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.entities.concretes.JobSeeker;

public interface JobSeekerCheckService {
    Result checkJobSeeker (JobSeeker jobSeeker);
}
