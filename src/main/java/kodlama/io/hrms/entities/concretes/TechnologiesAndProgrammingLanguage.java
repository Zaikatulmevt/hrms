package kodlama.io.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "technologies_or_programming_languages9")
public class TechnologiesAndProgrammingLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "cv_id")
    private int cvId;

    @Column(name = "technology_or_programming_language")
    private String technologyOrProgrammingLanguage;

    @Column(name = "created_date")
    private LocalDate createdDate;
}