package kodlama.io.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_experiences")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "cv"})
public class JobExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

//    @Column(name = "cv_id")
//    private int cv_id;

    @Column(name = "workplace_name")
    private String workPlaceName;

    @Column(name = "job_position_id")
    private int jobPositionId;

    @Column(name = "begin_date")
    private LocalDate beginDate;

    @Column(name = "finish_date")
    private LocalDate finishDate;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @ManyToOne
    @JoinColumn(name = "cv_id")
    private Cv cv;
}
