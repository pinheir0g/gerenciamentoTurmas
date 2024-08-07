package br.com.company.joker.jokerUniversity.mappers;

import br.com.company.joker.jokerUniversity.dtos.*;
import br.com.company.joker.jokerUniversity.models.Course;
import br.com.company.joker.jokerUniversity.models.Discipline;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface DisciplineMapper {

    DisciplineMapper INSTANCE = Mappers.getMapper(DisciplineMapper.class);

    DisciplineDTO toDTO(Discipline discipline);
    DisciplineGetDTO toGetDTO(Discipline discipline);
    Discipline toEntity(DisciplineDTO disciplineDTO);
    DisciplineResponseDTO toResponseDTO(Discipline discipline);
}