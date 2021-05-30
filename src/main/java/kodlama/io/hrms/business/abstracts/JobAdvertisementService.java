package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.Utilities.Results.DataResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementService {
    DataResult<List<JobAdvertisement>> findAllByActiveTrue();
    DataResult<List<JobAdvertisement>> findAllByActiveTrueOrderByCreatedDateDesc();
    DataResult<List<JobAdvertisement>> findAllByEmployer_IdAndActiveTrue(int employerId);
    Result add(JobAdvertisement jobAdvertisement);
    Result setValue(int id, boolean value);

}
