package br.com.company.joker.jokerUniversity.models;

import br.com.company.joker.jokerUniversity.dtos.StudentDTO;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "students")
public class Student extends User {


    @OneToOne
    private GradeRecord gradeRecord;

    public Student(StudentDTO alunoDTO) {
        this.gradeRecord = alunoDTO.getGradeRecord();
    }

}
