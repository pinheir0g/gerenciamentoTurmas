package br.com.company.joker.jokerUniversity.repositories;

import br.com.company.joker.jokerUniversity.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}