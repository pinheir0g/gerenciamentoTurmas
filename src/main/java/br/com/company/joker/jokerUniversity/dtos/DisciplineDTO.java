package br.com.company.joker.jokerUniversity.dtos;

import br.com.company.joker.jokerUniversity.models.Course;
import lombok.Data;

import java.io.Serializable;

@Data
public class DisciplineDTO implements Serializable {
    Integer disciplineID;
    String name;
    String description;
    Integer period;
    Course course;
}