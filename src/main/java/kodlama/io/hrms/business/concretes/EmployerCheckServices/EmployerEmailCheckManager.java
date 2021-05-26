package kodlama.io.hrms.business.concretes.EmployerCheckServices;

import kodlama.io.hrms.business.abstracts.EmployerCheckService;
import kodlama.io.hrms.core.Utilities.Results.ErrorResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.core.Utilities.Results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerEmailCheckManager implements EmployerCheckService {
    @Autowired
    private EmployerDao employerDao;

    @Override
    public Result checkEmployer(Employer employer) {
        if(this.employerDao.existsByEmail(employer.getEmail())){

            return new ErrorResult("Email already exists");

        }
        return new SuccessResult();
    }
}
