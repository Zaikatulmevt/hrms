package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.Utilities.Results.DataResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.entities.concretes.Cv;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CvService{

    DataResult<List<Cv>> getAll();
    Result add(Cv cv);
    DataResult<List<Cv>> findAllJobSeekerId(int jobSeekerId);
    Result uploadPhoto(MultipartFile file, int cvId);
}
