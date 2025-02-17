package org.example.homeservices.services;

import lombok.RequiredArgsConstructor;
import org.example.homeservices.entities.Client;
import org.example.homeservices.entities.Operateur;
import org.example.homeservices.entities.Role;
import org.example.homeservices.repository.UtilisateurRepository;
import org.example.homeservices.securité.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {

        @Autowired
        private UtilisateurRepository userRepository;
        private PasswordEncoder passwordEncoder;
        @Autowired
        private JwtService jwtService;

        @Override
        public String registerClient(Client client) {
            client.setPassword(passwordEncoder.encode(client.getPassword()));
            client.setRole(Role.Abonné);
            userRepository.save(client);
            return jwtService.generateToken(client);
        }

        @Override
        public String registerPrestataire(Operateur prestataire) {
            prestataire.setPassword(passwordEncoder.encode(prestataire.getPassword()));
            prestataire.setRole(Role.Operateur);
            userRepository.save(prestataire);
            return jwtService.generateToken(prestataire);
        }
    }


