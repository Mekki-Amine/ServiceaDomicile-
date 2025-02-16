package org.example.homeservices.services;

import org.example.homeservices.entities.Paiement;

import java.util.List;

public interface IPaiementService {

    public Paiement effectuerPaiement(Paiement paiement) ;

    public List<Paiement> getAllPaiements() ;
}
