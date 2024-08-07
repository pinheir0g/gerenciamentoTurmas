package br.com.company.joker.jokerUniversity.services;

import br.com.company.joker.jokerUniversity.dtos.*;
import br.com.company.joker.jokerUniversity.exceptions.EntidadeNotFoundException;
import br.com.company.joker.jokerUniversity.mappers.CourseMapper;
import br.com.company.joker.jokerUniversity.mappers.DisciplineMapper;
import br.com.company.joker.jokerUniversity.models.Course;
import br.com.company.joker.jokerUniversity.models.Discipline;
import br.com.company.joker.jokerUniversity.repositories.CourseRepository;
import br.com.company.joker.jokerUniversity.repositories.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DisciplineService {

    @Autowired
    DisciplineRepository disciplineRepository;

    @Autowired
    private CourseRepository courseRepository;

    public DisciplineDTO save(DisciplineDTO disciplineDTO) {
        Discipline discipline = new Discipline(disciplineDTO);

        Set<Course> courses = new HashSet<>(); // TODO: passar esse course para courseResponseDTO e resolve problema de cascata de discipline e course
        Set<CourseResponseDTO> coursesResponseDTO = new HashSet<>();
        for(CourseResponseDTO courseDTO : disciplineDTO.getCourses()){
           Integer id = courseDTO.getCourseID();

           Course course = courseRepository.findById(id).
                   orElseThrow(() -> new RuntimeException("No Courses found with id: " + id));

           CourseResponseDTO courseConvertedToDto = CourseMapper.INSTANCE.toResponseDTO(course);
           courses.add(course);

           coursesResponseDTO.add(courseConvertedToDto);

           course.getDisciplines().add(discipline); // necessário para associar um ao outro na tabela course_discipline(se não tiver retorna array vazio)
        }

        discipline.setCourses(courses);

        disciplineRepository.save(discipline);

        DisciplineDTO disciplineInstancedFinal = DisciplineMapper.INSTANCE.toDTO(discipline);
        disciplineInstancedFinal.setCourses(coursesResponseDTO);

        return disciplineInstancedFinal;
    }

    public DisciplineDTO update(DisciplineDTO disciplineDTO) {
        Integer disciplineID = disciplineDTO.getDisciplineID();
        Discipline discipline = disciplineRepository.findById(disciplineID).orElseThrow(
                () -> new EntidadeNotFoundException("No Discipline found by id :" + disciplineID));
        disciplineRepository.save(DisciplineMapper.INSTANCE.toEntity(disciplineDTO));
        DisciplineDTO disciplineDTOSave = DisciplineMapper.INSTANCE.toDTO(discipline);
        return disciplineDTOSave;
    }

    public DisciplineDTO findById(Integer id) {
        Discipline discipline = disciplineRepository.findById(id)
                .orElseThrow(() -> new EntidadeNotFoundException("No Discipline found by id :" + id));
        DisciplineDTO disciplineResponseDTO = DisciplineMapper.INSTANCE.toDTO(discipline);
        return disciplineResponseDTO;
    }

    public List<DisciplineDTO> findAll() {
        List<Discipline> disciplines = disciplineRepository.findAll();
        if (disciplines.isEmpty())
            throw new NoSuchElementException("No Discipline found!");
        List<DisciplineDTO> disciplineResponseDTO = new ArrayList<>(); // TODO: MUDAR PARA DISCIPLINERESPONSEDTO QUANDO RESOLVER ERRO AO RETORNAR COURSE
        for (Discipline discipline : disciplines) {
            disciplineResponseDTO.add(DisciplineMapper.INSTANCE.toDTO(discipline));
        }
        return disciplineResponseDTO;
    }

    public DisciplineDTO deleteById(Integer id) {
        Discipline discipline = disciplineRepository.findById(id)
                .orElseThrow(() -> new EntidadeNotFoundException("No Discipline found by id : " + id));
        disciplineRepository.deleteById(id);
        DisciplineDTO disciplineDTO = DisciplineMapper.INSTANCE.toDTO(discipline);
        return disciplineDTO;
    }
}
