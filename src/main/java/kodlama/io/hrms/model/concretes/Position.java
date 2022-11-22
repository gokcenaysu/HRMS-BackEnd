package kodlama.io.hrms.model.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "positions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @JsonIgnore()
    @OneToMany(mappedBy = "position")
    private List<Advertisement> advertisements;

    @JsonIgnore()
    @OneToMany(mappedBy = "position")
    private List<Department> departments;

}
