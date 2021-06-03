package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.CvService;
import kodlama.io.hrms.core.Utilities.Results.DataResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.core.Utilities.Results.SuccessDataResult;
import kodlama.io.hrms.core.Utilities.Results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CvDao;
import kodlama.io.hrms.entities.concretes.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvManager implements CvService {
    @Autowired
    private CvDao cvDao;

    @Override
    public DataResult<List<Cv>> getAll() {
        return new SuccessDataResult<List<Cv>>(this.cvDao.findAll(), "Successfully");
    }

    @Override
    public Result add(Cv cv) {
        this.cvDao.save(cv);
        return new SuccessResult("Successfully");
    }
}
