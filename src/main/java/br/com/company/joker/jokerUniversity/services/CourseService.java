package br.com.company.joker.jokerUniversity.services;

import br.com.company.joker.jokerUniversity.dtos.CourseDTO;
import br.com.company.joker.jokerUniversity.dtos.CourseGetDTO;
import br.com.company.joker.jokerUniversity.exceptions.EntidadeNotFoundException;
import br.com.company.joker.jokerUniversity.mappers.CourseMapper;
import br.com.company.joker.jokerUniversity.models.Course;
import br.com.company.joker.jokerUniversity.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public CourseDTO save(CourseDTO courseDTO) {

        Course courseSave = new Course(courseDTO);
        courseRepository.save(courseSave);

        CourseDTO courseDTOSave = CourseMapper.INSTANCE.toDTO(courseSave);
        return courseDTOSave;
    }

    public CourseDTO update(CourseDTO courseDTO) {
        Integer courseID = courseDTO.getCourseID();
        Course course = courseRepository.findById(courseID).orElseThrow(
                () -> new EntidadeNotFoundException("No Course find by id :" + courseID));
        courseRepository.save(CourseMapper.INSTANCE.toEntity(courseDTO));
        CourseDTO courseDTOSave = CourseMapper.INSTANCE.toDTO(course);
        return courseDTOSave;
    }

    public CourseGetDTO findById(Integer id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new EntidadeNotFoundException("No Course find by id :" + id));
        CourseGetDTO courseDTO = CourseMapper.INSTANCE.toGetDTO(course);
        return courseDTO;
    }

    public List<CourseGetDTO> findAll() {
        List<Course> courses = courseRepository.findAll();
        if (courses.isEmpty())
            throw new NoSuchElementException("No Course find!");
        List<CourseGetDTO> courseDto = new ArrayList<>();
        for (Course course : courses) {
            courseDto.add(CourseMapper.INSTANCE.toGetDTO(course));
        }
        return courseDto;
    }

    public CourseDTO deleteById(Integer id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new EntidadeNotFoundException("No Course find by id : " + id));
        courseRepository.deleteById(id);
        CourseDTO courseDTO = CourseMapper.INSTANCE.toDTO(course);
        return courseDTO;
    }
}
