package br.com.company.joker.jokerUniversity.models;

import br.com.company.joker.jokerUniversity.dtos.StudentDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentID;

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

    @OneToOne
    @JoinColumn(name = "grade_record_id")
    private GradeRecord gradeRecord;

    public Student(StudentDTO studentDTO) {
        this.studentID = studentDTO.getStudentID();
        this.fullName = studentDTO.getFullName();
        this.email = studentDTO.getEmail();
        this.password = studentDTO.getPassword();
        this.birthDate = studentDTO.getBirthDate();
        this.cpf = studentDTO.getCpf();
        this.naturalness = studentDTO.getNaturalness();
        this.nationality = studentDTO.getNationality();
        this.endereco = studentDTO.getEndereco();
        this.phone = studentDTO.getPhone();
        this.emergencyContact = studentDTO.getEmergencyContact();
        this.gradeRecord = studentDTO.getGradeRecord();
    }
}
