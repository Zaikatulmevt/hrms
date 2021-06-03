package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.TechnologiesAndProgrammingLanguageService;
import kodlama.io.hrms.core.Utilities.Results.DataResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.core.Utilities.Results.SuccessDataResult;
import kodlama.io.hrms.core.Utilities.Results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.TechnologiesAndProgrammingLanguageDao;
import kodlama.io.hrms.entities.concretes.TechnologiesAndProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologiesAndProgrammingLanguageManager implements TechnologiesAndProgrammingLanguageService {

    @Autowired
    private TechnologiesAndProgrammingLanguageDao technologiesAndProgrammingLanguageDao;
    @Override
    public DataResult<List<TechnologiesAndProgrammingLanguage>> getAll() {
        return new SuccessDataResult<List<TechnologiesAndProgrammingLanguage>>(this.technologiesAndProgrammingLanguageDao.findAll(),"Successfully");
    }

    @Override
    public Result add(TechnologiesAndProgrammingLanguage technologiesAndProgrammingLanguage) {
        this.technologiesAndProgrammingLanguageDao.save(technologiesAndProgrammingLanguage);
        return new SuccessResult("Successfully");
    }
}
