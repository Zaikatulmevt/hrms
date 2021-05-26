package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.entities.concretes.Employer;

public interface EmployerCheckService {

    Result checkEmployer(Employer employer);
}
