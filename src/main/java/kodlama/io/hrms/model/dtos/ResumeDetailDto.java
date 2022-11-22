package kodlama.io.hrms.model.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kodlama.io.hrms.model.concretes.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDetailDto {

    @JsonIgnore()
    private JobSeeker jobSeeker;
    private List<Language> languages;
    private List<Skill> skills;
    private List<Experience> experiences;
    private List<Link> links;
    private List<Photograph> photographs;
}
