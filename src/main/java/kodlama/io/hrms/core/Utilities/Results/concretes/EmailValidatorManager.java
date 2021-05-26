package kodlama.io.hrms.core.Utilities.Results.concretes;

import kodlama.io.hrms.core.Utilities.Results.abstracts.EmailValidatorService;
import kodlama.io.hrms.entities.concretes.User;
import org.springframework.stereotype.Service;

@Service

public class EmailValidatorManager implements EmailValidatorService {
    @Override

    public boolean checkEmail(User user) {
        return true;
    }
}
