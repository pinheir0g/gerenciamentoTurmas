package br.com.company.joker.jokerUniversity.dtos;

import br.com.company.joker.jokerUniversity.models.Course;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
public class DisciplineDTO implements Serializable {
    Integer disciplineID;
    String name;
    String description;
    Integer period;
    Set<Course> courses;
}