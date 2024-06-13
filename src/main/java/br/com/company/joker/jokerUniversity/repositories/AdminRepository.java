package br.com.company.joker.jokerUniversity.repositories;

import br.com.company.joker.jokerUniversity.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
}