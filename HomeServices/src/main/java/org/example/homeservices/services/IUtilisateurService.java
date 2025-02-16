package org.example.homeservices.services;

import org.example.homeservices.entities.Utilisateur;


import java.util.List;
import java.util.Optional;

public interface IUtilisateurService {




        public List<Utilisateur> findAll() ;

        public Optional<Utilisateur> findById(Long id) ;

        public Utilisateur save(Utilisateur utilisateur) ;

        public void deleteById(Long id) ;

}
