package kodlama.io.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_positions")
public class JobPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "job_position_name")
    private String position;
    @OneToMany(mappedBy = "jobPosition")
    @JsonIgnore
    private List<JobAdvertisement> jobAdvertisements;

    @OneToMany(mappedBy = "jobPosition")
    @JsonIgnore
    private List<JobExperience> jobExperiences;
}
