package kodlama.io.hrms.model.concretes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "personnels")
@NoArgsConstructor
@Getter
@Setter
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    public Admin(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
}
