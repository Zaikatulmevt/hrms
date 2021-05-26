package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.entities.concretes.JobPosition;

public interface JobPositionCheckService {
    Result jobPositionCheck(JobPosition jobPosition);
}
