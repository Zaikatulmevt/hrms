package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.JobPositionCheckService;
import kodlama.io.hrms.core.Utilities.Results.ErrorResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.core.Utilities.Results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobPositionDao;
import kodlama.io.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobPositionCheckManager implements JobPositionCheckService {

    @Autowired
    private JobPositionDao jobPositionDao;


    @Override
    public Result jobPositionCheck(JobPosition jobPosition) {
        if(this.jobPositionDao.existsByPosition(jobPosition.getPosition())){

            return new ErrorResult("This position already exists.");

        }
        return new SuccessResult();
    }
}
