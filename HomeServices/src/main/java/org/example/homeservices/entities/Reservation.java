package org.example.homeservices.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private LocalDateTime dateHeure;

    @NotNull
    private Double prix;

    @Enumerated(EnumType.STRING)
    private StatutReservation statut; // CONFIRMEE, EN_COURS, TERMINEE

    @ManyToOne
    private Utilisateur utilisateur ;


}