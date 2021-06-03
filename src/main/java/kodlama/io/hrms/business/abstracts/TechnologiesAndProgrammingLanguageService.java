package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.Utilities.Results.DataResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.entities.concretes.ForeignLanguage;
import kodlama.io.hrms.entities.concretes.TechnologiesAndProgrammingLanguage;

import java.util.List;

public interface TechnologiesAndProgrammingLanguageService {

    DataResult<List<TechnologiesAndProgrammingLanguage>> getAll();
    Result add(TechnologiesAndProgrammingLanguage technologiesAndProgrammingLanguage);

}
