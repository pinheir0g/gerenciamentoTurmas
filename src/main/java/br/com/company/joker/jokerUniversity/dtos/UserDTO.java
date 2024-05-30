package br.com.company.joker.jokerUniversity.dtos;

import br.com.company.joker.jokerUniversity.models.Address;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {
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
}
