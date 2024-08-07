package br.com.company.joker.jokerUniversity.models;

import br.com.company.joker.jokerUniversity.dtos.CourseDTO;
import br.com.company.joker.jokerUniversity.dtos.DisciplineDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(
            name = "course_discipline",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "discipline_id")
    )
    private Set<Discipline> disciplines = new HashSet<>();

    public Course (CourseDTO courseDTO) {
        this.courseID = courseDTO.getCourseID();
        this.courseName = courseDTO.getCourseName();
        this.description = courseDTO.getDescription();
        this.duration = courseDTO.getDuration();
    }

}
