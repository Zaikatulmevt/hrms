package kodlama.io.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "employer_id")
@Table(name = "employers")
public class Employer extends User{

    @Column(name = "company_name")
    private String companyName;
    @Column(name = "web_site")
    private String webSite;
    @Column(name = "phone_number")
    private String phoneNumber;
    @OneToMany(mappedBy = "employer")
    @JsonIgnore
    private List<JobAdvertisement> jobAdvertisements;
}
