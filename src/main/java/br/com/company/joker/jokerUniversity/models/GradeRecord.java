package br.com.company.joker.jokerUniversity.models;

import br.com.company.joker.jokerUniversity.dtos.GradeRecordDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "grade_records")
public class GradeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_record_id")
    private Integer gradeRecordID;

    public GradeRecord(GradeRecordDTO gradeRecordDTO) {
        this.gradeRecordID = gradeRecordDTO.getGradeRecordID();
    }
}
