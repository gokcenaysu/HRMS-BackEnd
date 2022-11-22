package kodlama.io.hrms.model.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "working_times")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkingTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(name = "time")
    private String time;

    @JsonIgnore()
    @OneToMany(mappedBy = "workingTime")
    private List<Advertisement> advertisements;
}
