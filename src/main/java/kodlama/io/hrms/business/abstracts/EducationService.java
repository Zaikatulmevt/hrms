package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.Utilities.Results.DataResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.entities.concretes.Cv;
import kodlama.io.hrms.entities.concretes.Education;

import java.util.List;

public interface EducationService {

    DataResult<List<Education>> getAll();
    Result add(Education education);
    DataResult<List<Education>> findAllByCvIdOOrderByFinishDateDesc(int cvId);
}
