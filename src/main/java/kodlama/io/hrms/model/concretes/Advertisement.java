package kodlama.io.hrms.model.concretes;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="advertisements")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="description")
    private String description;

    @Column(name="min_Salary")
    private double minSalary;

    @Column(name="max_Salary")
    private double maxSalary;

    @Column(name="open_position_count")
    private int openPositionCount;

    @FutureOrPresent
    @Column(name="application_deadline")
    private LocalDate applicationDeadline;

    @Column(name="creation_date")
    private LocalDateTime creationDate = LocalDateTime.now();

    @Column(name="is_remote")
    private boolean isRemote;

    @Column(name="activity_status")
    private boolean activityStatus;

    @ManyToOne()
    @JoinColumn(name="employer_id")
    private Employer employer;

    @ManyToOne()
    @JoinColumn(name="position_id")
    private Position position;

    @ManyToOne()
    @JoinColumn(name="working_time_id")
    private WorkingTime workingTime;

}
