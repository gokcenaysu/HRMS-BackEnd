package kodlama.io.hrms.model.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="photographs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Photograph {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="photo")
    private String photo;

    @Column(name = "created_on")
    private LocalDateTime createdOn = LocalDateTime.now();

    @JsonIgnore()
    @ManyToOne()
    @JoinColumn(name="jobSeeker_id")
    private JobSeeker jobSeeker;

//    @JsonIgnore()
//    @ManyToOne()
//    @JoinColumn(name="user_id")
//    private User user;
}
