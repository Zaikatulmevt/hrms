package kodlama.io.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cvs")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobSeeker"})
public class Cv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

//    @Column(name = "job_seeker_id")
//    private int jobSeekerId;

    @Column(name = "photo")
    private String photo;

    @Column(name = "github_link")
    private String githubLink;

    @Column(name = "linkedin_link")
    private String linkedinLink;

    @Column(name = "description")
    private String description;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "latest_update_date")
    private LocalDate latestUpdateDate;

    @Column(name = "is_active")
    private boolean isActive;



    @OneToMany(mappedBy = "cv")
    private List<Education> educations;
    @OneToMany(mappedBy = "cv")
    private List<ForeignLanguages> foreignLanguages;
    @OneToMany(mappedBy = "cv")
    private List<JobExperience> jobExperiences;
    @OneToMany(mappedBy = "cv")
    private List<TechnologiesAndProgrammingLanguage> technologiesAndProgrammingLanguages;
    @ManyToOne
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;

}
