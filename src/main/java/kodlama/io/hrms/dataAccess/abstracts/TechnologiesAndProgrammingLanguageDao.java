package kodlama.io.hrms.dataAccess.abstracts;

import kodlama.io.hrms.entities.concretes.TechnologiesAndProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologiesAndProgrammingLanguageDao extends JpaRepository<TechnologiesAndProgrammingLanguage, Integer> {
}
