package org.example.homeservices.services;

import org.example.homeservices.entities.Paiement;
import org.example.homeservices.repository.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PaiementService implements IPaiementService {

    @Autowired
    private PaiementRepository paiementRepository;

    @Override
    public Paiement effectuerPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }
    @Override
    public List<Paiement> getAllPaiements() {
        return paiementRepository.findAll();
    }
}