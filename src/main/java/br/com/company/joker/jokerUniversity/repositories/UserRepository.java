package br.com.company.joker.jokerUniversity.repositories;

import br.com.company.joker.jokerUniversity.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
