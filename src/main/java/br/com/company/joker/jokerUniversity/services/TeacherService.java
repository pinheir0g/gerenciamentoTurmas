package br.com.company.joker.jokerUniversity.services;

import br.com.company.joker.jokerUniversity.dtos.TeacherDTO;
import br.com.company.joker.jokerUniversity.exceptions.EntidadeNotFoundException;
import br.com.company.joker.jokerUniversity.mappers.TeacherMapper;
import br.com.company.joker.jokerUniversity.models.Teacher;
import br.com.company.joker.jokerUniversity.repositories.TeacherRepository;


import br.com.company.joker.jokerUniversity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;



@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    UserRepository userRepository;

    public TeacherDTO createUserAndTeacher(TeacherDTO teacherDTO) {

        User userSave = new User(teacherDTO.getFullName(), teacherDTO.getEmail(), teacherDTO.getPassword(),
                teacherDTO.getBirthDate(), teacherDTO.getCpf(), teacherDTO.getNaturalness(), teacherDTO.getNationality(),
                teacherDTO.getEndereco(), teacherDTO.getPhone(), teacherDTO.getEmergencyContact());

        userRepository.save(userSave);

        Teacher teacherSave = new Teacher(teacherDTO);
        teacherSave.setUserId(userSave.getUserId());
        teacherRepository.save(teacherSave);

        TeacherDTO teacherDTOSave = TeacherMapper.INSTANCE.toDTO(teacherSave);
        return teacherDTOSave;
    }

    public List<TeacherDTO> findAll() {
        List<Teacher> teachers = teacherRepository.findAll();
        if (teachers.isEmpty())
            throw new NoSuchElementException("No teacher find!");
        List<TeacherDTO> teacherDto = new ArrayList<>();
        for (Teacher teacher : teachers) {
            teacherDto.add(TeacherMapper.INSTANCE.toDTO(teacher));
        }
        return teacherDto;
    }

    public TeacherDTO findById(Integer id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new EntidadeNotFoundException("No teacher find by id :" + id));
        TeacherDTO teacherDTO = TeacherMapper.INSTANCE.toDTO(teacher);
        return teacherDTO;
    }

    public TeacherDTO update(TeacherDTO teacherDTO) {
        Integer teacherID = teacherDTO.getUserID();
        Teacher teacher = teacherRepository.findById(teacherID).orElseThrow(
                () -> new EntidadeNotFoundException("No teacher find by id :" + teacherID));
        ;
        teacherRepository.save(teacher);
        TeacherDTO teacherDTOSalvo = TeacherMapper.INSTANCE.toDTO(teacher);
        return teacherDTOSalvo;
    }

    public TeacherDTO deleteById(Integer id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new EntidadeNotFoundException("No teacher find by id : " + id));
        teacherRepository.deleteById(id);
        TeacherDTO teacherDto = TeacherMapper.INSTANCE.toDTO(teacher);
        return teacherDto;
    }
}
