package kodlama.io.hrms.model.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name="universities")
public class  University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="university")
    private String university;

//    @Column(name="start_year")
//    private LocalDate startYear;
//
//    @Column(name="graduation_year")
//    private LocalDate graduationYear;

    @JsonIgnore()
    @ManyToOne()
    @JoinColumn(name = "jobSeeker_id")
    private JobSeeker jobSeeker;

    @ManyToOne()
    @JoinColumn(name="city_id")
    private City city;

    @JsonIgnore
    @OneToMany()
    @JoinColumn(name="university_id")
    private List<Faculty> faculties;


}
