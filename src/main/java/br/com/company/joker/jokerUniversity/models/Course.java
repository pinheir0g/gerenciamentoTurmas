package br.com.company.joker.jokerUniversity.models;

import br.com.company.joker.jokerUniversity.dtos.CourseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseID;

    @Column(name = "name")
    private String courseName;

    @Column(name = "description")
    private String description;

    @Column(name = "duration")
    private Integer duration;

    public Course (CourseDTO courseDTO) {
        this.courseID = courseDTO.getCourseID();
        this.courseName = courseDTO.getCourseName();
        this.description = courseDTO.getDescription();
        this.duration = courseDTO.getDuration();
    }
}
