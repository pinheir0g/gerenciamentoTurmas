package br.com.company.joker.jokerUniversity.mappers;

import br.com.company.joker.jokerUniversity.dtos.*;
import br.com.company.joker.jokerUniversity.models.Discipline;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DisciplineMapper {

    DisciplineMapper INSTANCE = Mappers.getMapper(DisciplineMapper.class);

    DisciplineDTO toDTO(Discipline discipline);
    DisciplineGetDTO toGetDTO(Discipline discipline);
    Discipline toEntity(DisciplineDTO disciplineDTO);

    @Mapping(source = "courses", target = "courses") // funciona como um indicador para qual atributo da classe principal relacionar no DTO
    DisciplineResponseDTO toResponseDTO(Discipline discipline);
}
