package kodlama.io.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "job_seekers_id")
@Table(name = "job_seekers")
@Entity
public class JobSeeker extends User{

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "nationality_id")
    private String nationalityId;
    @Column(name = "birthday_day")
    private LocalDate birthday;

    @OneToMany(mappedBy = "jobSeeker")
    private List<Cv> cvs;



}
