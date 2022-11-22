package kodlama.io.hrms.model.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kodlama.io.hrms.core.entities.User;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "job_seekers")
@PrimaryKeyJoinColumn(name = "id")
@NoArgsConstructor
@Getter
@Setter
public class JobSeeker extends User {

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="identity_number")
    private String identityNumber;

    @Column(name="birth_year")
    private String birthYear;

    @JsonIgnore()
    @OneToMany(mappedBy = "jobSeeker")
    private List<University> universities;

    @JsonIgnore()
    @OneToMany(mappedBy = "jobSeeker")
    private List<Language> languages;

    @JsonIgnore()
    @OneToMany(mappedBy = "jobSeeker")
    private List<Photograph> photographs;

    @JsonIgnore()
    @OneToMany(mappedBy = "jobSeeker")
    private List<Link> links;

    @JsonIgnore()
    @OneToMany(mappedBy = "jobSeeker")
    private List<Skill> skills;

    @JsonIgnore()
    @OneToMany(mappedBy = "jobSeeker")
    private List<Experience> experiences;




}
