package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.Utilities.Results.DataResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.entities.concretes.ForeignLanguage;
import kodlama.io.hrms.entities.concretes.JobExperience;

import java.util.List;

public interface JobExperienceService {

    DataResult<List<JobExperience>> getAll();
    Result add(JobExperience jobExperience);
    DataResult<List<JobExperience>> findAllByCvIdOrderByFinishDateDesc(int cvId);
}
