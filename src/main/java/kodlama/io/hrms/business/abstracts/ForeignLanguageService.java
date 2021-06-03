package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.Utilities.Results.DataResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.entities.concretes.ForeignLanguage;

import java.util.List;

public interface ForeignLanguageService {

    DataResult<List<ForeignLanguage>> getAll();
    Result add(ForeignLanguage foreignLanguage);
}
