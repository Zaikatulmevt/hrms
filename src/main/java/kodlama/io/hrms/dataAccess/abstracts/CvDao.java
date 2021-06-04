package kodlama.io.hrms.dataAccess.abstracts;

import kodlama.io.hrms.entities.concretes.Cv;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;
import java.util.List;

public interface CvDao extends JpaRepository<Cv, Integer> {

    List<Cv> findAllByJobSeeker_Id(int jobseekerId);
}
