package br.com.company.joker.jokerUniversity.mappers;

import br.com.company.joker.jokerUniversity.dtos.GradeRecordDTO;
import br.com.company.joker.jokerUniversity.models.GradeRecord;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GradeRecordMapper {
    GradeRecordMapper INSTANCE = Mappers.getMapper(GradeRecordMapper.class);

    GradeRecordDTO toDTO( GradeRecord historicoEscolar);
    GradeRecord toEntity( GradeRecordDTO historicoEscolarDTO);
}
