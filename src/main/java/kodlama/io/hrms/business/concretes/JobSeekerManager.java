package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.JobSeekerCheckService;
import kodlama.io.hrms.business.abstracts.JobSeekerService;
import kodlama.io.hrms.core.Utilities.Results.DataResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.core.Utilities.Results.SuccessDataResult;
import kodlama.io.hrms.core.Utilities.Results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;
    private JobSeekerCheckService jobSeekerCheckService;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao, JobSeekerCheckService jobSeekerCheckService) {
        this.jobSeekerDao = jobSeekerDao;
        this.jobSeekerCheckService = jobSeekerCheckService;
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),"Başarılı" );
    }

    @Override
    public Result add(JobSeeker jobSeeker) {
        if (!this.jobSeekerCheckService.checkJobSeeker(jobSeeker).isSuccess()) {
            return this.jobSeekerCheckService.checkJobSeeker(jobSeeker);
        }
        this.jobSeekerDao.save(jobSeeker);
        return new SuccessResult("Eklendi");
    }
}
