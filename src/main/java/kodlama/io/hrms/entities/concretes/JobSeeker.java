package kodlama.io.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "job_seekers_id")
@Table(name = "job_seekers")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "cvs"})
public class JobSeeker extends User{

    @Column(name = "first_name")
    @NotNull
    private String firstName;


    @Column(name = "last_name")
    @NotNull
    private String lastName;


    @Column(name = "nationality_id")
    @NotNull
    private String nationalityId;


    @Column(name = "birthday_day")
    @NotNull
    private LocalDate birthday;

    @JsonIgnore
    @OneToMany(mappedBy = "jobSeeker")
    private List<Cv> cvs;



}
