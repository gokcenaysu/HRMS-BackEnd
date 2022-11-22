package kodlama.io.hrms.model.concretes;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "faculties")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "faculty")
    private String faculty;

    @Column(name = "department")
    private String department;

    @ManyToOne()
    @JoinColumn(name = "university_id")
    private University university;

}
