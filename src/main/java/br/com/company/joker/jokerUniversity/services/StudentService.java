package br.com.company.joker.jokerUniversity.services;

import br.com.company.joker.jokerUniversity.dtos.StudentDTO;
import br.com.company.joker.jokerUniversity.dtos.UserDTO;
import br.com.company.joker.jokerUniversity.exceptions.EntidadeNotFoundException;
import br.com.company.joker.jokerUniversity.mappers.StudentMapper;
import br.com.company.joker.jokerUniversity.models.Student;
import br.com.company.joker.jokerUniversity.models.User;
import br.com.company.joker.jokerUniversity.repositories.StudentRepository;
import br.com.company.joker.jokerUniversity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    UserRepository userRepository;

    public StudentDTO createUserAndStudent(StudentDTO studentDTO) {

        User userSave = new User(studentDTO.getFullName(), studentDTO.getEmail(), studentDTO.getPassword(),
                studentDTO.getBirthDate(), studentDTO.getCpf(), studentDTO.getNaturalness(), studentDTO.getNationality(),
                studentDTO.getEndereco(), studentDTO.getPhone(), studentDTO.getEmergencyContact());

        userRepository.save(userSave);

        Student studentSave = new Student(studentDTO);
        studentSave.setUserID(userSave.getUserID());
        studentRepository.save(studentSave);

        StudentDTO studentDTOSave = StudentMapper.INSTANCE.toDTO(studentSave);
        return studentDTOSave;
    }


    public StudentDTO update(StudentDTO studentDTO) {
        Integer studentID = studentDTO.getUserID();
        Student student = studentRepository.findById(studentID).orElseThrow(
                () -> new EntidadeNotFoundException("No student find by id :" + studentID));
        ;
        studentRepository.save(student);
        StudentDTO studentDTOSave = StudentMapper.INSTANCE.toDTO(student);
        return studentDTOSave;
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
