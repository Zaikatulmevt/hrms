package kodlama.io.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_advertisement")
public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;


    @Column(name = "description", nullable = false)
    @NotNull
    private String description;


    @Column(name = "max_salary")
    private int maxSalary;


    @Column(name = "min_salary")
    private int minSalary;


    @Column(name = "open_job_positions", nullable = false)
    @NotNull
    private int openJobPositions;


    @Column(name = "latest_apply_date", nullable = false)
    @NotNull
    private LocalDate latestApplyDate;


    @Column(name = "is_active", nullable = false)
    @NotNull
    private boolean active;


    @Column(name = "created_date", nullable = false)
    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    @NotNull
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    @ManyToOne
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

}
