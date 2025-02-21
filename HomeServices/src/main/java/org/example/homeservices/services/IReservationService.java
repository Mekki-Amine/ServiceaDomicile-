package org.example.homeservices.services;

import org.example.homeservices.entities.Reservation;


import java.util.List;
import java.util.Optional;

public interface IReservationService {

    public List<Reservation> findAll() ;

    public Optional<Reservation> findById(Long id) ;

    public Reservation save(Reservation reservation) ;

    public void deleteById(Long id) ;

    public List<Reservation> findByUtilisateurId(Long Id) ;

}
