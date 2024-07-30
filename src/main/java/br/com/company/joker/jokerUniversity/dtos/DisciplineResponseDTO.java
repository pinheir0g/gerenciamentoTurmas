package br.com.company.joker.jokerUniversity.dtos;

import lombok.Data;

@Data
public class DisciplineResponseDTO {
    Integer disciplineID;
    String name;
    String description;
    Integer period;
}
