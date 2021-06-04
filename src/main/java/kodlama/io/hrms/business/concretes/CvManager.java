package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.adapters.abstracts.CloudinaryService;
import kodlama.io.hrms.business.abstracts.CvService;
import kodlama.io.hrms.core.Utilities.Results.DataResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.core.Utilities.Results.SuccessDataResult;
import kodlama.io.hrms.core.Utilities.Results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CvDao;
import kodlama.io.hrms.entities.concretes.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class CvManager implements CvService {
    @Autowired
    private CvDao cvDao;
    @Autowired
    private CloudinaryService cloudinaryService;

    @Override
    public DataResult<List<Cv>> getAll() {
        return new SuccessDataResult<List<Cv>>(this.cvDao.findAll(), "Successfully");
    }

    @Override
    public Result add(Cv cv) {
        this.cvDao.save(cv);
        return new SuccessResult("Successfully");
    }

    @Override
    public DataResult<List<Cv>> findAllJobSeekerId(int jobSeekerId) {
        return new SuccessDataResult<List<Cv>>(this.cvDao.findAllByJobSeeker_Id(jobSeekerId), "Succesfully listed Cvs");
    }

    @Override
    public Result uploadPhoto(MultipartFile file, int cvId) {
        Map<String, String> uploader = (Map<String, String>)
                cloudinaryService.uploadPhoto(file).getData();
        String imageUrl= uploader.get("url");
        Cv cv = cvDao.getOne(cvId);
        cv.setPhoto(imageUrl);
        cvDao.save(cv);
        return new SuccessResult("Kayıt Başarılı");
    }

}
