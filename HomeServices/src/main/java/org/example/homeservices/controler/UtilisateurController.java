package org.example.homeservices.controler;

import lombok.RequiredArgsConstructor;

import org.example.homeservices.entities.Utilisateur;
import org.example.homeservices.services.IUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/utilisateurs")
@RequiredArgsConstructor
public class UtilisateurController {

    @Autowired
    private IUtilisateurService utilisateurService;


    @GetMapping
    public List<Utilisateur> findAll() {
        return utilisateurService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> findById(@PathVariable Long id) {
        Optional<Utilisateur> utilisateur = utilisateurService.findById(id);
        return utilisateur.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }



    @PostMapping("/register/requestUser")
    public ResponseEntity<Utilisateur>  creatCompte(@RequestBody Utilisateur requestUser) {
        Utilisateur newUser = utilisateurService.creatCompte(requestUser);
        return ResponseEntity.ok(newUser);
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