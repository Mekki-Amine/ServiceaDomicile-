package org.example.homeservices.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paiement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Double montant;

    @NotBlank
    private String modePaiement; // PayPal , Carte Bancaire

    @Enumerated(EnumType.STRING)
    private StatutPaiement statut; // PAYE, EN_ATTENTE

    @ManyToOne
    private Utilisateur utilisateur;

    @OneToOne
    @JoinColumn(name = "reservation")
    private Reservation reservation;
}
