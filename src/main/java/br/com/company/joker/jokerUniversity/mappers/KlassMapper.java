package br.com.company.joker.jokerUniversity.mappers;

import br.com.company.joker.jokerUniversity.dtos.KlassDTO;
import br.com.company.joker.jokerUniversity.models.Klass;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface KlassMapper {

    KlassMapper INSTANCE = Mappers.getMapper(KlassMapper.class);

    KlassDTO toDTO(Klass klass);
    Klass toEntity(KlassDTO klassDTO);
}