package kodlama.io.hrms.adapters.concretes;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import kodlama.io.hrms.adapters.abstracts.CloudinaryService;
import kodlama.io.hrms.core.Utilities.Results.DataResult;
import kodlama.io.hrms.core.Utilities.Results.ErrorDataResult;
import kodlama.io.hrms.core.Utilities.Results.SuccessDataResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryServiceAdapter implements CloudinaryService {

    @Override
    public DataResult<?> uploadPhoto(MultipartFile file) {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "metehanmelih",
                "api_key", "756657815879859",
                "api_secret", "JlJ1GgUHLQhVyxRjYX9wc5D2v1Y"));

        try{
            Map cloudinaryUploader = cloudinary.uploader()
                    .upload(file.getBytes()
                            ,ObjectUtils.emptyMap());
            return new SuccessDataResult<Map>(cloudinaryUploader);
        }

        catch (IOException exception){
            exception.printStackTrace();
        }
        return new ErrorDataResult<Map>();
    }
}
