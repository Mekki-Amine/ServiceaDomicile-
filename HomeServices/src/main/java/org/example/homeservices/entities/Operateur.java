package org.example.homeservices.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Operateur extends Utilisateur  {

    @NotBlank
    private String specialite;
    private boolean disponible;

    @OneToMany(mappedBy = "operateur")
    private List<Reservation> reservations ;

    @ManyToOne
    private Servicees serviceees;
}
