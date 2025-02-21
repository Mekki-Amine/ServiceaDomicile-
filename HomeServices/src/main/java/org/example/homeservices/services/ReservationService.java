package org.example.homeservices.services;
import org.example.homeservices.entities.Reservation;
import org.example.homeservices.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ReservationService implements IReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }
    @Override
    public Optional<Reservation> findById(Long id) {
        return reservationRepository.findById(id);
    }
    @Override
    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
    @Override
    public void deleteById(Long id) {
        reservationRepository.deleteById(id);
    }
    @Override
    public List<Reservation> findByUtilisateurId(Long Id) {
        return reservationRepository.findByUtilisateurId(Id);
    }

}