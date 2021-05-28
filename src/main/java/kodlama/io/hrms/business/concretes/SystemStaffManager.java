package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.SystemStaffService;
import org.springframework.stereotype.Service;

@Service
public class SystemStaffManager implements SystemStaffService {
    @Override
    public boolean validateEmployer() {
        return true;
    }
}
