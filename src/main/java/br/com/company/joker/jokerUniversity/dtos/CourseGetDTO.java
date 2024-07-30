package br.com.company.joker.jokerUniversity.dtos;

import br.com.company.joker.jokerUniversity.models.Discipline;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
public class CourseGetDTO implements Serializable {
    Integer courseID;
    String courseName;
    String description;
    Integer duration;
    Set<DisciplineGetDTO> discipline;
}
