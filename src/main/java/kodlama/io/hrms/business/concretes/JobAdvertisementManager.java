package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.core.Utilities.Results.DataResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.core.Utilities.Results.SuccessDataResult;
import kodlama.io.hrms.core.Utilities.Results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    @Autowired
    private JobAdvertisementDao jobAdvertisementDao;

    @Override
    public DataResult<List<JobAdvertisement>> findAllByActiveTrue() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByActiveTrue());
    }

    @Override
    public DataResult<List<JobAdvertisement>> findAllByActiveTrueOrderByCreatedDateDesc() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByActiveTrueOrderByCreatedDateDesc());
    }

    @Override
    public DataResult<List<JobAdvertisement>> findAllByEmployer_IdAndActiveTrue(int employerId) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByEmployer_IdAndActiveTrue(employerId));
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("Job added successfully.");
    }

    @Override
    public Result setValue(int id, boolean value) {
        JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.findById(id).get();
        jobAdvertisement.setActive(value);
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult();
    }
}
