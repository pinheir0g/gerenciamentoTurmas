package br.com.company.joker.jokerUniversity.models;

import br.com.company.joker.jokerUniversity.dtos.DisciplineDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "discipline")
public class Discipline {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer disciplineID;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "period")
  private Integer period;

  @OneToMany(mappedBy = "discipline")
  private Course course;

  public Discipline(DisciplineDTO disciplineDTO) {
    this.name = disciplineDTO.getName();
    this.description = disciplineDTO.getDescription();
    this.period = disciplineDTO.getPeriod();
    this.course = disciplineDTO.getCourse();
  }
}