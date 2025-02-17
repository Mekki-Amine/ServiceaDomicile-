package org.example.homeservices.services;

import org.example.homeservices.entities.Client;
import org.example.homeservices.entities.Operateur;

public interface IAuthService {
    public String registerClient(Client client) ;

    public String registerPrestataire(Operateur prestataire) ;
}
