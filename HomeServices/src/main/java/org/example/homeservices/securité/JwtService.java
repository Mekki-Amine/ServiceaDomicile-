package org.example.homeservices.securité;


import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.SignatureAlgorithm;
import org.example.homeservices.entities.Utilisateur;

import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class JwtService {

    // Clé secrète (à changer par une vraie clé dans votre projet)
    private static final String SECRET_KEY = "aty2FUyfSYIYWm0QJjyZatd99nmfmCHUnDWCK6ME+kk=";


    // Générer le token JWT
    public String generateToken(Utilisateur utilisateur) {
        return Jwts.builder()
                .setSubject(utilisateur.getEmail()) // Le nom d'utilisateur est l'email
                .setIssuedAt(new  Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // Expiration dans 10 heures
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY) // Utilisation de la signature HS256
                .compact();
    }

    // Valider le token JWT
    public boolean validateToken(String token, Utilisateur utilisateur) {
        String username = extractUsername(token);
        return (username.equals(utilisateur.getEmail()) && !isTokenExpired(token));
    }

    // Extraire le nom d'utilisateur du token
    public String extractUsername(String token) {
        return Jwts.parser() // Utilisation de parserBuilder
                .setSigningKey(SECRET_KEY)
                .build() // Créer un JwtParser à partir du parserBuilder
                .parseClaimsJws(token) // Extraire les claims
                .getBody()
                .getSubject();
    }

    // Vérifier si le token est expiré
    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Extraire la date d'expiration du token
    public Date extractExpiration(String token) {
        return Jwts.parser() // Utilisation de parserBuilder
                .setSigningKey(SECRET_KEY)
                .build() // Créer un JwtParser à partir du parserBuilder
                .parseClaimsJws(token) // Extraire les claims
                .getBody()
                .getExpiration();
    }
}