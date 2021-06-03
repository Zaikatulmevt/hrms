package kodlama.io.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "educations")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "cv"})
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;


    @Column(name = "school_name")
    @NotNull
    private String schoolName;

    @Column(name = "field")
    @NotNull
    private String field;

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
    @JoinColumn(name="cv_id")
    private Cv cv;
}
