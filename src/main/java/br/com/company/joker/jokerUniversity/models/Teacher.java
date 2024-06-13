package br.com.company.joker.jokerUniversity.models;

import br.com.company.joker.jokerUniversity.dtos.TeacherDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "teachers")
public class Teacher{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Integer teacherID;
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
    @Column(name = "academic_education")
    private String academicEducation;

    public Teacher(TeacherDTO teacherDTO) {
        this.teacherID = teacherDTO.getTeacherID();
        this.fullName = teacherDTO.getFullName();
        this.email = teacherDTO.getEmail();
        this.password = teacherDTO.getPassword();
        this.birthDate = teacherDTO.getBirthDate();
        this.cpf = teacherDTO.getCpf();
        this.naturalness = teacherDTO.getNaturalness();
        this.nationality = teacherDTO.getNationality();
        this.endereco  = teacherDTO.getEndereco();
        this.phone  = teacherDTO.getPhone();
        this.emergencyContact  = teacherDTO.getEmergencyContact();
        this.academicEducation = teacherDTO.getAcademicEducation();

    }
}
