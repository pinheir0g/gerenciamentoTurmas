package br.com.company.joker.jokerUniversity.models;

import br.com.company.joker.jokerUniversity.dtos.GradeRecordDTO;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "grades_records")
public class GradeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "")
    private Integer gradeRecordID;

    public GradeRecord(GradeRecordDTO gradeRecordDTO) {
        this.gradeRecordID = gradeRecordDTO.getGradeRecordID();
    }
}
