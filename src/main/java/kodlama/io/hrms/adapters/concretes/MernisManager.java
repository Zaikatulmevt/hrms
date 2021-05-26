package kodlama.io.hrms.adapters.concretes;

import kodlama.io.hrms.adapters.abstracts.MernisService;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import org.springframework.stereotype.Service;

@Service
public class MernisManager implements MernisService {
    @Override
    public boolean checkNationalId(JobSeeker jobSeeker) {
        //Mernis kodları yazılmaktadır.
        return true;
    }
}
