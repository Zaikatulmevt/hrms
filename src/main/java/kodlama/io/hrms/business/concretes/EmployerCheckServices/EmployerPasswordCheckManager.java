package kodlama.io.hrms.business.concretes.EmployerCheckServices;

import kodlama.io.hrms.business.abstracts.EmployerCheckService;
import kodlama.io.hrms.core.Utilities.Results.ErrorResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.core.Utilities.Results.SuccessResult;
import kodlama.io.hrms.entities.concretes.Employer;
import org.springframework.stereotype.Service;

@Service
public class EmployerPasswordCheckManager implements EmployerCheckService {
    @Override
    public Result checkEmployer(Employer employer) {
        if(employer.getPassword().equals(employer.getPassword2())){
            return new SuccessResult();

        }
        return new ErrorResult("Password must be same");

    }
}
