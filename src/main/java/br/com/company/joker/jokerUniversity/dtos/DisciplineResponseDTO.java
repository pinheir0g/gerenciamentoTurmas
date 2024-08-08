package br.com.company.joker.jokerUniversity.dtos;

import br.com.company.joker.jokerUniversity.models.Course;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class DisciplineResponseDTO implements Serializable {
    Integer disciplineID;
    String name;
    String description;
    Integer period;
    Set<CourseResponseDTO> courses;
}
