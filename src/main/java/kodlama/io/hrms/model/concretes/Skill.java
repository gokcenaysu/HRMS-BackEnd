package kodlama.io.hrms.model.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "programmings")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="programming")
    private String programming;

    @JsonIgnore()
    @ManyToOne()
    @JoinColumn(name="jobSeeker_id")
    private JobSeeker jobSeeker;
}
