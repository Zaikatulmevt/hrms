package kodlama.io.hrms.dataAccess.abstracts;

import kodlama.io.hrms.entities.concretes.JobExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobExperinceDao extends JpaRepository<JobExperience, Integer> {
    List<JobExperience> findAllByCv_IdOrderByFinishDateDesc(int cvId);
}
