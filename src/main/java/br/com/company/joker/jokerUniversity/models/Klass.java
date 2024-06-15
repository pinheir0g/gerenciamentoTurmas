package br.com.company.joker.jokerUniversity.models;

import br.com.company.joker.jokerUniversity.dtos.KlassDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "classes")
public class Klass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private Integer klassID;

    @ManyToMany
    @Column(name= "student_id")
    private List<Student> student;

    @OneToOne
    @JoinColumn(name= "teacher_id")
    private Teacher teacher;

    @OneToOne
    @JoinColumn(name = "discipline_id", unique = true)
    private Discipline discipline;

    @Column(name = "shift")
    private String shift;

    @Column(name = "grades")
    private String grades;

    @Column(name = "time")
    private String time;

    public Klass(KlassDTO klassDTO) {
        this.klassID = klassDTO.getKlassID();
        this.student = klassDTO.getStudent();
        this.teacher = klassDTO.getTeacher();
        this.discipline = klassDTO.getDiscipline();
        this.shift = klassDTO.getShift();
        this.grades = klassDTO.getGrades();
        this.time = klassDTO.getTime();
    }
}
