package br.com.company.joker.jokerUniversity.repositories;

import br.com.company.joker.jokerUniversity.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}