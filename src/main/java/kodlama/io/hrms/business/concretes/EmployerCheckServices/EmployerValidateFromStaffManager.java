package kodlama.io.hrms.business.concretes.EmployerCheckServices;

import kodlama.io.hrms.business.abstracts.EmployerCheckService;
import kodlama.io.hrms.business.abstracts.SystemStaffService;
import kodlama.io.hrms.business.concretes.SystemStaffManager;
import kodlama.io.hrms.core.Utilities.Results.ErrorResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.core.Utilities.Results.SuccessResult;
import kodlama.io.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerValidateFromStaffManager implements EmployerCheckService {

    @Autowired
    private SystemStaffService systemStaffService;


    @Override
    public Result checkEmployer(Employer employer) {
        if (this.systemStaffService.validateEmployer()) {
            return new SuccessResult();
        }

        return new ErrorResult("You need the staff validate");
    }
}
