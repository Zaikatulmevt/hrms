package kodlama.io.hrms.business.concretes.EmployerCheckServices;

import kodlama.io.hrms.business.abstracts.EmployerCheckService;
import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.core.Utilities.Results.DataResult;
import kodlama.io.hrms.core.Utilities.Results.ErrorResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.core.Utilities.Results.SuccessResult;
import kodlama.io.hrms.entities.concretes.Employer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployerFieldServiceManager implements EmployerCheckService {
    @Override
    public Result checkEmployer(Employer employer) {
        if(employer.getCompanyName().isEmpty() || employer.getEmail().isEmpty() || employer.getPassword().isEmpty()
                || employer.getPhoneNumber().isEmpty() || employer.getWebSite().isEmpty()) {
            return new ErrorResult("You have too fill all of slots");
        }
        return new SuccessResult();
        }
    }

