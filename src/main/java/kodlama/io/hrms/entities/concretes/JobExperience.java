package kodlama.io.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_experiences")
public class JobExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;



    @Column(name = "workplace_name")
    @NotNull
    private String workPlaceName;


    @Column(name = "begin_date")
    @NotNull
    private LocalDate beginDate;

    @Column(name = "finish_date")
    private LocalDate finishDate;

    @Column(name = "created_date")
    @CreationTimestamp
    @NotNull
    private LocalDate createdDate;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "cv_id")
    private Cv cv;
    @ManyToOne
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;
}
