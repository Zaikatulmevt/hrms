package kodlama.io.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cvs")
public class Cv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "job_seeker_id")
    private int jobSeekerId;

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


}
