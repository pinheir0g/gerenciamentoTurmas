package br.com.company.joker.jokerUniversity.models;

import br.com.company.joker.jokerUniversity.dtos.AdminDTO;
import br.com.company.joker.jokerUniversity.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Integer adminID;

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

    @Column(name = "role")
    private RoleEnum role;


    public Admin(AdminDTO adminDTO) {
        this.adminID = adminDTO.getAdminID();
        this.fullName = adminDTO.getFullName();   ;
        this.email = adminDTO.getEmail();
        this.password = adminDTO.getPassword();
        this.birthDate = adminDTO.getBirthDate();
        this.cpf = adminDTO.getCpf();
        this.naturalness = adminDTO.getNaturalness();
        this.nationality = adminDTO.getNationality();
        this.endereco = adminDTO.getEndereco();
        this.phone = adminDTO.getPhone();
        this.emergencyContact = adminDTO.getEmergencyContact();
        this.role = adminDTO.getRole();
    }
}
