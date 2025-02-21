package org.example.homeservices.services;
import lombok.RequiredArgsConstructor;
import org.example.homeservices.entities.Utilisateur;
import org.example.homeservices.repository.UtilisateurRepository;
import org.example.homeservices.securité.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UtilisateurService implements IUtilisateurService {

    private PasswordEncoder passwordEncoder;

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private JwtService jwtService;

    @Override
    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Optional<Utilisateur> findById(Long id) {
        return utilisateurRepository.findById(id);
    }
    @Override
    public Utilisateur creatCompte(Utilisateur requestUser) {

        if (utilisateurRepository.existsByEmail(requestUser.getEmail())) {
            throw new RuntimeException("COMPTE_EXISTS_MESSAGE");
            }

        Utilisateur savedUtilisateur = utilisateurRepository.save(requestUser);

        String token = jwtService.generateToken(savedUtilisateur) ;


                System.out.println("COMPTE_CREATION_SUCCESS");
                System.out.println("COMPTE_CREATION_MESSAGE");

         return requestUser ;

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
