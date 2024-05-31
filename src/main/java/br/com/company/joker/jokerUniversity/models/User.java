package br.com.company.joker.jokerUniversity.models;

import br.com.company.joker.jokerUniversity.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userID;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "naturalness")
    private String naturalness;
    @Column(name = "nationality")
    private String nationality;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address endereco;
    @Column(name = "phone")
    private String phone;
    @Column(name = "emergency_contact")
    private String emergencyContact;

    public User(UserDTO userDTO) {
        this.fullName = userDTO.getFullName();
        this.email = userDTO.getEmail();
        this.password = userDTO.getPassword();
        this.birthDate = userDTO.getBirthDate();
        this.cpf = userDTO.getCpf();
        this.naturalness = userDTO.getNaturalness();
        this.nationality = userDTO.getNationality();
        this.endereco = userDTO.getEndereco();
        this.phone = userDTO.getPhone();
        this.emergencyContact = userDTO.getEmergencyContact();
    }

    public User(String fullName, String email, String password, LocalDate birthDate, String cpf, String naturalness,
                String nationality, Address endereco, String phone, String emergencyContact) {
    }
}
