package kodlama.io.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;
    @Column(name = "e_mail")
    @NotNull
    private String email;
    @Column(name = "password")
    @NotNull
    private String password;
    //Bu değiken persistance değil. Database'e aktarılmıyor.
    @Transient
    private String password2;
}
