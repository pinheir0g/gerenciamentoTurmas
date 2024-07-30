package br.com.company.joker.jokerUniversity.dtos;

import lombok.Data;

import java.util.Set;

@Data
public class DisciplineResponseDTO {
    Integer id;
    String name;
    String description;
    Integer period;
    Set<CourseResponseDTO> courseIds;
}
