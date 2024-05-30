package br.com.company.joker.jokerUniversity.services;

import br.com.company.joker.jokerUniversity.dtos.StudentDTO;
import br.com.company.joker.jokerUniversity.exceptions.EntidadeNotFoundException;
import br.com.company.joker.jokerUniversity.mappers.StudentMapper;
import br.com.company.joker.jokerUniversity.models.Student;
import br.com.company.joker.jokerUniversity.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public StudentDTO save(StudentDTO studentDTO) {
        Student studentSalvo = studentRepository.save(new Student(studentDTO));
        StudentDTO studentDTOSalvo = StudentMapper.INSTANCE.toDTO(studentSalvo);
        return studentDTOSalvo;
    }

    public StudentDTO update(StudentDTO studentDTO) {
        Integer studentID = studentDTO.getUserID();
        Student student = studentRepository.findById(studentID).orElseThrow(
                () -> new EntidadeNotFoundException("No student find by id :" + studentID));
        ;
        studentRepository.save(student);
        StudentDTO studentDTOSalvo = StudentMapper.INSTANCE.toDTO(student);
        return studentDTOSalvo;
    }
    public StudentDTO findById(Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new EntidadeNotFoundException("No student find by id :" + id));
        StudentDTO studentDTO = StudentMapper.INSTANCE.toDTO(student);
        return studentDTO;
    }

    public List<StudentDTO> findAll() {
        List<Student>  students = studentRepository.findAll();
        if (students.isEmpty())
            throw new NoSuchElementException("No student find!");
        List<StudentDTO> studentsDto = new ArrayList<>();
        for (Student  student : students) {
            studentsDto.add(StudentMapper.INSTANCE.toDTO(student));
        }
        return studentsDto;
    }

    public StudentDTO deleteById(Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new EntidadeNotFoundException("No student find by id : " + id));
        studentRepository.deleteById(id);
        StudentDTO studentDto = StudentMapper.INSTANCE.toDTO(student);
        return studentDto;
    }
}
