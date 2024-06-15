package br.com.company.joker.jokerUniversity.models;

import br.com.company.joker.jokerUniversity.dtos.CourseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer courseID;

    @Column(name = "name")
    private String courseName;

    @Column(name = "description")
    private String description;

    @Column(name = "duration")
    private Integer duration;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private List<Discipline> discipline;

    public Course (CourseDTO courseDTO) {
        this.courseID = courseDTO.getCourseID();
        this.courseName = courseDTO.getCourseName();
        this.description = courseDTO.getDescription();
        this.duration = courseDTO.getDuration();
        this.discipline = courseDTO.getDiscipline();
    }
}
