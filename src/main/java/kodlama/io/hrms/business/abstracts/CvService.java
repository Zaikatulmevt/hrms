package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.Utilities.Results.DataResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.entities.concretes.Cv;

import java.util.List;

public interface CvService{

    DataResult<List<Cv>> getAll();
    Result add(Cv cv);


}
