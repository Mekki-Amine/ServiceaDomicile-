package org.example.homeservices.controler;

import org.example.homeservices.entities.Reservation;
import org.example.homeservices.services.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private IReservationService reservationService;

    @GetMapping
    public List<Reservation> findAll() {
        return reservationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> findById(@PathVariable Long id) {
        Optional<Reservation> reservation = reservationService.findById(id);
        return reservation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Reservation save(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        reservationService.deleteById(id);
    }

    @GetMapping("/client/{clientId}")
    public List<Reservation> findByUtilisateurtId(@PathVariable Long clientId) {
        return reservationService.findByUtilisateurId(clientId);
    }



}


