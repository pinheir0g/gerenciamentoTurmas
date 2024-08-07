package br.com.company.joker.jokerUniversity.models;

import br.com.company.joker.jokerUniversity.dtos.CourseResponseDTO;
import br.com.company.joker.jokerUniversity.dtos.DisciplineDTO;
import br.com.company.joker.jokerUniversity.dtos.DisciplineResponseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "discipline")
public class Discipline {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "discipline_id")
  private Integer disciplineID;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "period")
  private Integer period;

  @ManyToMany(mappedBy = "disciplines", fetch = FetchType.EAGER)
  private Set<Course> courses = new HashSet<>();

  public Discipline(DisciplineDTO disciplineDTO) {
    this.name = disciplineDTO.getName();
    this.description = disciplineDTO.getDescription();
    this.period = disciplineDTO.getPeriod();
    this.courses = disciplineDTO.getCourses();
  }

//  public void setCourses(Set<CourseResponseDTO> courses) {
//    this.courses = courses
//  }
}