package br.com.company.joker.jokerUniversity.mappers;

import br.com.company.joker.jokerUniversity.dtos.DisciplineDTO;
import br.com.company.joker.jokerUniversity.models.Discipline;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DisciplineMapper {

    DisciplineMapper INSTANCE = Mappers.getMapper(DisciplineMapper.class);

    DisciplineDTO toDTO(Discipline discipline);
    Discipline toEntity(DisciplineDTO disciplineDTO);
}
