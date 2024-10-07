package org.example.pruebabanco.repositories;

import org.example.pruebabanco.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends JpaRepository<ClientEntity, Long> {
}
