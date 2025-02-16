package org.example.homeservices.controler;

import org.example.homeservices.entities.Paiement;
import org.example.homeservices.services.IPaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
public class PaiementController {

    @Autowired
    private IPaiementService paiementService;

    @PostMapping("/payer")
    public ResponseEntity<Paiement> effectuerPaiement(@RequestBody Paiement paiement) {
        return ResponseEntity.ok(paiementService.effectuerPaiement(paiement));
    }

    @GetMapping("/liste")
    public ResponseEntity<List<Paiement>> getAllPaiements() {
        return ResponseEntity.ok(paiementService.getAllPaiements());
    }
}