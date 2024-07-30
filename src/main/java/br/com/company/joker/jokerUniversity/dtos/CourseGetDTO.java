package br.com.company.joker.jokerUniversity.dtos;

import br.com.company.joker.jokerUniversity.models.Discipline;
import lombok.Data;

import java.util.List;

@Data
public class CourseGetDTO {
    Integer courseID;
    String courseName;
    String description;
    Integer duration;
    List<Discipline> discipline;
}
