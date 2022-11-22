package kodlama.io.hrms.model.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kodlama.io.hrms.core.entities.User;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "id")
@NoArgsConstructor
@Getter
@Setter
public class Employer extends User {

    @Column(name = "company")
    private String company;

    @Column(name = "website")
    private String website;

    @Column(name = "phone_number")
    private String phoneNumber;

    @JsonIgnore()
    @OneToMany(mappedBy = "employer")
    private List<Advertisement> advertisements;

    @JsonIgnore()
    @OneToMany(mappedBy = "employer")
    private List<Experience> experiences;
}
