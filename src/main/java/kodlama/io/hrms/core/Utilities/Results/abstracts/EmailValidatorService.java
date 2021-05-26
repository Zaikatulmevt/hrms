package kodlama.io.hrms.core.Utilities.Results.abstracts;

import kodlama.io.hrms.entities.concretes.User;

public interface EmailValidatorService {
    boolean checkEmail(User user);
}
