package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.EmployerCheckService;
import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.business.abstracts.JobSeekerCheckService;
import kodlama.io.hrms.core.Utilities.Results.DataResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.core.Utilities.Results.SuccessDataResult;
import kodlama.io.hrms.core.Utilities.Results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployerManager implements EmployerService {
    @Autowired
    private EmployerDao employerDao;

    @Autowired
    private EmployerCheckService[] employerCheckServices;


    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Başarılı" );
    }

    @Override
    public Result add(Employer employer) {
        for (EmployerCheckService employerCheckService : employerCheckServices) {
            if(employerCheckService.checkEmployer(employer).isSuccess() == false) {
                return employerCheckService.checkEmployer(employer);
            }
        }
        this.employerDao.save(employer);
        return new SuccessResult("Eklendi");
    }
}
