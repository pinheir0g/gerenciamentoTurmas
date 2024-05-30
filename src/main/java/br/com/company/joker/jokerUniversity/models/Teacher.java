package br.com.company.joker.jokerUniversity.models;

import br.com.company.joker.jokerUniversity.dtos.TeacherDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "teachers")
public class Teacher extends User{
    @Column(name = "academic_education")
    private String academicEducation;

    public Teacher(TeacherDTO teacherDTO) {
        this.academicEducation = teacherDTO.getAcademicEducation();
    }
}
