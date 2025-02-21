package org.example.homeservices.services;


import org.example.homeservices.entities.Utilisateur;


import java.util.List;
import java.util.Optional;

public interface IUtilisateurService {




        public List<Utilisateur> findAll() ;

        public Optional<Utilisateur> findById(Long id) ;

        public Utilisateur creatCompte(Utilisateur requestUser) ;

        public void deleteById(Long id) ;

        public Utilisateur updateUser(Long id, Utilisateur user);

}
