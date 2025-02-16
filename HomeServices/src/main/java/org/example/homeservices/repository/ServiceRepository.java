package org.example.homeservices.repository;

import org.example.homeservices.entities.Servicees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Servicees, Long> {}