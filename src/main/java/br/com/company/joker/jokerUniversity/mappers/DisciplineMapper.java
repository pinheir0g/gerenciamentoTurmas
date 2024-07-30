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

    default CourseResponseDTO toCourseResponseDTO(Course course) {
        CourseResponseDTO dto = new CourseResponseDTO();
        dto.setCourseID(course.getCourseID());
        dto.setCourseName(course.getCourseName());
        return dto;
    }

    public default DisciplineResponseDTO toResponseDTO(Discipline discipline){
        DisciplineResponseDTO disciplineResponseDTO = new DisciplineResponseDTO();

        Set<CourseResponseDTO> courseResponseDTO = new HashSet<>();

        disciplineResponseDTO.setId(discipline.getDisciplineID());
        disciplineResponseDTO.setDescription(discipline.getDescription());
        disciplineResponseDTO.setName(discipline.getName());
        disciplineResponseDTO.setPeriod(discipline.getPeriod());

        Set<CourseResponseDTO> courseResponseDTOs = discipline.getCourses().stream()
                .map(this::toCourseResponseDTO)
                .collect(Collectors.toSet());

        disciplineResponseDTO.setCourseIds(courseResponseDTOs);

        return disciplineResponseDTO;
    }
}
