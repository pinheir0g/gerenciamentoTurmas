package br.com.company.joker.jokerUniversity.models;

import br.com.company.joker.jokerUniversity.dtos.StudentDTO;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
@PrimaryKeyJoinColumn(name="user_id")
public class Student extends User {

    @OneToOne
    @JoinColumn(name="grade_record_id")
    private GradeRecord gradeRecord;

    public Student(StudentDTO studentDTO) {
        super();
        this.gradeRecord = studentDTO.getGradeRecord();
    }
}
