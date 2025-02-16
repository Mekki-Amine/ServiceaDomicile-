package org.example.homeservices.repository;

import org.example.homeservices.entities.Operateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperateurRepo extends JpaRepository<Operateur, Long> {
}
