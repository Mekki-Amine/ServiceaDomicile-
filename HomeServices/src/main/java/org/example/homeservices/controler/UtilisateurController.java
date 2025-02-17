package org.example.homeservices.controller;

import org.example.homeservices.entities.Utilisateur;
import org.example.homeservices.services.IUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    @Autowired
    private IUtilisateurService UtilisateurService;
    @Autowired
    private org.example.homeservices.services.UtilisateurService utilisateurService;

    @GetMapping
    public List<Utilisateur> findAll() {
        return utilisateurService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> findById(@PathVariable Long id) {
        Optional<Utilisateur> utilisateur = utilisateurService.findById(id);
        return utilisateur.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Utilisateur save(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.save(utilisateur);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        utilisateurService.deleteById(id);

    }

    @PutMapping("/{id}")
    public Utilisateur updateUser(@PathVariable Long id, @RequestBody Utilisateur user) {
        return utilisateurService.updateUser(id, user);
    }
}