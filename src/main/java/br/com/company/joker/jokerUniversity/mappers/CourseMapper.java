package br.com.company.joker.jokerUniversity.mappers;

import br.com.company.joker.jokerUniversity.dtos.CourseDTO;
import br.com.company.joker.jokerUniversity.dtos.CourseGetDTO;
import br.com.company.joker.jokerUniversity.dtos.CourseResponseDTO;
import br.com.company.joker.jokerUniversity.models.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface CourseMapper {

    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    CourseGetDTO toGetDTO(Course course);
    CourseDTO toDTO(Course course);
    Course toEntity(CourseDTO courseDTO);

    CourseResponseDTO toResponseDTO(Course course);
}