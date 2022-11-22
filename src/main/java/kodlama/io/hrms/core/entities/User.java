package kodlama.io.hrms.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kodlama.io.hrms.model.concretes.Link;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

//    @JsonIgnore()
//    @OneToMany(mappedBy = "user")
//    private List<Photograph> photographs;

    @JsonIgnore()
    @OneToMany(mappedBy = "user")
    private List<Link> links;


    public User(int id, String email, String password) {
        super();
        this.id = id;
        this.email = email;
        this.password = password;
    }
}
