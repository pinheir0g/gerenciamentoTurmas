package br.com.company.joker.jokerUniversity.mappers;

import br.com.company.joker.jokerUniversity.dtos.TeacherDTO;
import br.com.company.joker.jokerUniversity.models.Teacher;
import org.mapstruct.factory.Mappers;

public interface TeacherMapper {
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    TeacherDTO toDTO(Teacher teacher);
    Teacher toEntity(TeacherDTO teacherDTO);
}