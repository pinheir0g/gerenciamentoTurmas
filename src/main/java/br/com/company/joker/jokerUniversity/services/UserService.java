package br.com.company.joker.jokerUniversity.services;

import br.com.company.joker.jokerUniversity.dtos.StudentDTO;
import br.com.company.joker.jokerUniversity.dtos.UserDTO;
import br.com.company.joker.jokerUniversity.models.Student;
import br.com.company.joker.jokerUniversity.models.User;
import br.com.company.joker.jokerUniversity.repositories.StudentRepository;
import br.com.company.joker.jokerUniversity.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    StudentRepository studentRepository;

    @Transactional
    public UserDTO createUserAndStudent(UserDTO userDTO) {
      //SAVE USER


        //SAVE STUDENT

        return UserDTO;
    }
}
