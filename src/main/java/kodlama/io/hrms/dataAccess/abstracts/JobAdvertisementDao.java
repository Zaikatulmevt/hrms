package kodlama.io.hrms.dataAccess.abstracts;

import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
    List<JobAdvertisement> findAllByActiveTrue();
    List<JobAdvertisement> findAllByActiveTrueOrderByCreatedDateDesc();
    List<JobAdvertisement> findAllByEmployer_IdAndActiveTrue(int employerId);
}
