package br.com.company.joker.jokerUniversity.repositories;

import br.com.company.joker.jokerUniversity.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}