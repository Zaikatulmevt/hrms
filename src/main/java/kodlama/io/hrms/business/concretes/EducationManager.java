package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.EducationService;
import kodlama.io.hrms.core.Utilities.Results.DataResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.core.Utilities.Results.SuccessDataResult;
import kodlama.io.hrms.core.Utilities.Results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EducationDao;
import kodlama.io.hrms.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationManager implements EducationService {

    @Autowired
    private EducationDao educationDao;
    @Override
    public DataResult<List<Education>> getAll() {
        return new SuccessDataResult<List<Education>>(this.educationDao.findAll(),"Successfully");
    }

    @Override
    public Result add(Education education) {
        this.educationDao.save(education);
        return  new SuccessResult("Succesfully");
    }

    @Override
    public DataResult<List<Education>> findAllByCvIdOOrderByFinishDateDesc(int cvId) {
        return new SuccessDataResult<List<Education>>(this.educationDao.findAllByCv_IdOrderByFinishDateDesc(cvId), "Educations Are Listed");
    }
}
