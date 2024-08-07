package br.com.company.joker.jokerUniversity.dtos;

import br.com.company.joker.jokerUniversity.models.Course;
import lombok.Data;

import java.util.Set;

@Data
public class DisciplineResponseDTO {
    Integer id;
    String name;
    String description;
    Integer period;
    Set<Course> courses;
}
