package org.example.homeservices.services;
import org.example.homeservices.entities.Utilisateur;
import org.example.homeservices.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UtilisateurService implements IUtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Optional<Utilisateur> findById(Long id) {
        return utilisateurRepository.findById(id);
    }
    @Override
    public Utilisateur save(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }
    @Override
    public void deleteById(Long id) {
        utilisateurRepository.deleteById(id);
    }
    @Override
    public Utilisateur updateUser(Long id, Utilisateur user) {
        user.setId(id);
        return utilisateurRepository.save(user);
    }
}
