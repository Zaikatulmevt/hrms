package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.Utilities.Results.DataResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {

    DataResult<List<Employer>> getAll();
    Result add(Employer employer);
}
