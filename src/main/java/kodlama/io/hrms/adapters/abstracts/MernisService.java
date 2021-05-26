package kodlama.io.hrms.adapters.abstracts;

import kodlama.io.hrms.entities.concretes.JobSeeker;

public interface MernisService {
    boolean checkNationalId (JobSeeker jobSeeker);
}
