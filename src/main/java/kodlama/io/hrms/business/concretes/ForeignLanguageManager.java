package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.ForeignLanguageService;
import kodlama.io.hrms.core.Utilities.Results.DataResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.core.Utilities.Results.SuccessDataResult;
import kodlama.io.hrms.core.Utilities.Results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.ForeignLanguageDao;
import kodlama.io.hrms.entities.concretes.ForeignLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForeignLanguageManager implements ForeignLanguageService {
    @Autowired
    private ForeignLanguageDao foreignLanguageDao;
    @Override
    public DataResult<List<ForeignLanguage>> getAll() {
        return new SuccessDataResult<List<ForeignLanguage>>(this.foreignLanguageDao.findAll(), "Successfully");
    }

    @Override
    public Result add(ForeignLanguage foreignLanguage) {
        this.foreignLanguageDao.save(foreignLanguage);
        return new SuccessResult("Successfully");
    }
}
