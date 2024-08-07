package br.com.company.joker.jokerUniversity.dtos;

import lombok.Data;

import java.util.Set;

@Data
public class DisciplineGetDTO {
    Integer disciplineID;
    String name;
    String description;
    Integer period;
}
