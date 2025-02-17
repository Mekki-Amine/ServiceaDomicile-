package org.example.homeservices.controler;

import lombok.RequiredArgsConstructor;
import org.example.homeservices.entities.Client;
import org.example.homeservices.entities.Operateur;
import org.example.homeservices.services.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    private IAuthService authService;

    @PostMapping("/register/client")
    public ResponseEntity<String> registerClient(@RequestBody Client client) {
        String token = authService.registerClient(client);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register/prestataire")
    public ResponseEntity<String> registerPrestataire(@RequestBody Operateur prestataire) {
        String token = authService.registerPrestataire(prestataire);
        return ResponseEntity.ok(token);
    }
}