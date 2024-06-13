package br.com.company.joker.jokerUniversity.dtos;

import br.com.company.joker.jokerUniversity.models.Address;
import br.com.company.joker.jokerUniversity.models.GradeRecord;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentDTO {
    private Integer studentID;
    private String fullName;
    private String email;
    private String password;
    private LocalDate birthDate;
    private String cpf;
    private String naturalness;
    private String nationality;
    private Address endereco;
    private String phone;
    private String emergencyContact;
    private GradeRecord gradeRecord;

    public StudentDTO() {

    }
}



