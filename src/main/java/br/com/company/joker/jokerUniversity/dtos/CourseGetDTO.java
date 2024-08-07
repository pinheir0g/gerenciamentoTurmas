package br.com.company.joker.jokerUniversity.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class CourseGetDTO implements Serializable {
    Integer courseID;
    String courseName;
    String description;
    Integer duration;
    Set<DisciplineGetDTO> disciplines;
}
