package kodlama.io.hrms.adapters.abstracts;

import kodlama.io.hrms.core.Utilities.Results.DataResult;
import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {
    DataResult<?> uploadPhoto(MultipartFile file);
}
