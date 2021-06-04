package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.JobExperienceService;
import kodlama.io.hrms.core.Utilities.Results.DataResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.core.Utilities.Results.SuccessDataResult;
import kodlama.io.hrms.core.Utilities.Results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobExperinceDao;
import kodlama.io.hrms.entities.concretes.JobExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobExperienceManager implements JobExperienceService {

    @Autowired
    private JobExperinceDao jobExperinceDao;


    @Override
    public DataResult<List<JobExperience>> getAll() {
        return new SuccessDataResult<List<JobExperience>>(this.jobExperinceDao.findAll(),"Successfully");
    }

    @Override
    public Result add(JobExperience jobExperience) {
        this.jobExperinceDao.save(jobExperience);
        return new SuccessResult("Successfully");
    }

    @Override
    public DataResult<List<JobExperience>> findAllByCvIdOrderByFinishDateDesc(int cvId) {
        return new SuccessDataResult<List<JobExperience>>(this.jobExperinceDao.findAllByCv_IdOrderByFinishDateDesc(cvId), "Listed Successfully");
    }
}
