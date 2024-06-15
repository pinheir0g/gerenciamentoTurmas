package br.com.company.joker.jokerUniversity.dtos;

import br.com.company.joker.jokerUniversity.models.Discipline;
import br.com.company.joker.jokerUniversity.models.Student;
import br.com.company.joker.jokerUniversity.models.Teacher;
import lombok.Data;

import java.util.List;

@Data
public class KlassDTO {
    private Integer klassID;
    private List<Student> student;
    private Teacher teacher;
    private Discipline discipline;
    private String shift;
    private String grades;
    private String time;
}
