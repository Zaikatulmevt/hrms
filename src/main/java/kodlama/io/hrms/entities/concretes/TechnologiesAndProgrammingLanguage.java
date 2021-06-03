package kodlama.io.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "technologies_or_programming_languages")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "cv"})
public class TechnologiesAndProgrammingLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;


    @Column(name = "technology_or_programming_language")
    @NotNull
    private String technologyOrProgrammingLanguage;

    @Column(name = "created_date")
    @CreationTimestamp
    @NotNull
    private LocalDate createdDate;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name="cv_id")
    private Cv cv;
}
