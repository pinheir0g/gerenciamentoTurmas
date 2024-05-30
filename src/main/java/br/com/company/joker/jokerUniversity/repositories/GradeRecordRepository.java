package br.com.company.joker.jokerUniversity.repositories;

import br.com.company.joker.jokerUniversity.models.GradeRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRecordRepository extends JpaRepository<GradeRecord, Integer> {
}