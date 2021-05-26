package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.JobPositionCheckService;
import kodlama.io.hrms.business.abstracts.JobPositionService;
import kodlama.io.hrms.core.Utilities.Results.*;
import kodlama.io.hrms.dataAccess.abstracts.JobPositionDao;
import kodlama.io.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;
    @Autowired
    private JobPositionCheckService jobPositionCheckService;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "Job Positions Listed");
    }

    @Override
    public Result add(JobPosition jobPosition) {

        if(this.jobPositionCheckService.jobPositionCheck(jobPosition).isSuccess() == false){
            return this.jobPositionCheckService.jobPositionCheck(jobPosition);

        }
        this.jobPositionDao.save(jobPosition);
        return new SuccessResult("Added");

    }


}
