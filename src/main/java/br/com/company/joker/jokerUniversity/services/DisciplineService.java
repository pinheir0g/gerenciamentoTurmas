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
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DisciplineService {

    @Autowired
    DisciplineRepository disciplineRepository;

    @Autowired
    private CourseRepository courseRepository;

    public DisciplineDTO save(DisciplineDTO disciplineDTO) {

        Set<Course> courses = new HashSet<>();
        for(Course courseId : disciplineDTO.getCourses()){
           Integer id = courseId.getCourseID();

           Course course = courseRepository.findById(id).
                   orElseThrow(() -> new RuntimeException("No Courses found with id: " + courseId));
           courses.add(course);
        }

        Discipline disciplineSave = new Discipline(disciplineDTO, courses);
        disciplineRepository.save(disciplineSave);


        DisciplineDTO disciplineDTOSave = DisciplineMapper.INSTANCE.toDTO(disciplineSave);
        return disciplineDTOSave;
    }

    public DisciplineDTO update(DisciplineDTO disciplineDTO) {
        Integer disciplineID = disciplineDTO.getDisciplineID();
        Discipline discipline = disciplineRepository.findById(disciplineID).orElseThrow(
                () -> new EntidadeNotFoundException("No Discipline found by id :" + disciplineID));
        disciplineRepository.save(DisciplineMapper.INSTANCE.toEntity(disciplineDTO));
        DisciplineDTO disciplineDTOSave = DisciplineMapper.INSTANCE.toDTO(discipline);
        return disciplineDTOSave;
    }

    public DisciplineResponseDTO findById(Integer id) {
        Discipline discipline = disciplineRepository.findById(id)
                .orElseThrow(() -> new EntidadeNotFoundException("No Discipline found by id :" + id));
        DisciplineResponseDTO disciplineResponseDTO = DisciplineMapper.INSTANCE.toResponseDTO(discipline);
        return disciplineResponseDTO;
    }

    public List<DisciplineResponseDTO> findAll() {
        List<Discipline> disciplines = disciplineRepository.findAll();
        if (disciplines.isEmpty())
            throw new NoSuchElementException("No Discipline found!");
        List<DisciplineResponseDTO> disciplineResponseDTO = new ArrayList<>();
        for (Discipline discipline : disciplines) {
            disciplineResponseDTO.add(DisciplineMapper.INSTANCE.toResponseDTO(discipline));
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
