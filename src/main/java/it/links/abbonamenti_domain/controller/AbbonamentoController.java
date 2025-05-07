package it.links.abbonamenti_domain.controller;

import it.links.abbonamenti_domain.entity.AbbonamentoEntity;
import it.links.abbonamenti_domain.service.AbbonamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/abbonamenti")
public class AbbonamentoController {

    @Autowired
    private AbbonamentoService abbonamentoService;

    // Endpoint per creare un nuovo abbonamento
    @PostMapping
    public ResponseEntity<AbbonamentoEntity> createAbbonamento(@RequestBody AbbonamentoEntity abbonamento) {
        AbbonamentoEntity newAbbonamento = abbonamentoService.createAbbonamento(abbonamento);
        return new ResponseEntity<>(newAbbonamento, HttpStatus.CREATED);
    }

    // Endpoint per ottenere tutti gli abbonamenti
    @GetMapping
    public ResponseEntity<List<AbbonamentoEntity>> getAllAbbonamenti() {
        List<AbbonamentoEntity> abbonamenti = abbonamentoService.getAllAbbonamenti();
        return new ResponseEntity<>(abbonamenti, HttpStatus.OK);
    }

    // Endpoint per ottenere un abbonamento specifico tramite ID
    @GetMapping("/{id}")
    public ResponseEntity<AbbonamentoEntity> getAbbonamentoById(@PathVariable Long id) {
        Optional<AbbonamentoEntity> abbonamento = abbonamentoService.getAbbonamentoById(id);
        return abbonamento.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Endpoint per aggiornare un abbonamento
    @PutMapping("/{id}")
    public ResponseEntity<AbbonamentoEntity> updateAbbonamento(@PathVariable Long id, @RequestBody AbbonamentoEntity abbonamento) {
        AbbonamentoEntity updatedAbbonamento = abbonamentoService.updateAbbonamento(id, abbonamento);
        return new ResponseEntity<>(updatedAbbonamento, HttpStatus.OK);
    }

    // Endpoint per eliminare un abbonamento
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAbbonamento(@PathVariable Long id) {
        abbonamentoService.deleteAbbonamento(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Endpoint per associare un utente a un abbonamento
    @PostMapping("/{abbonamentoId}/utente/{utenteId}")
    public ResponseEntity<AbbonamentoEntity> associaUtenteAlAbbonamento(
            @PathVariable Long abbonamentoId,
            @PathVariable Long utenteId) {
        AbbonamentoEntity updatedAbbonamento = abbonamentoService.associaUtenteAlAbbonamento(abbonamentoId, utenteId);
        return new ResponseEntity<>(updatedAbbonamento, HttpStatus.OK);
    }

    // Endpoint per associare dettagli abbonamento a un abbonamento
    @PostMapping("/{abbonamentoId}/dettagli/{dettagliId}")
    public ResponseEntity<AbbonamentoEntity> associaDettagliAbbonamento(
            @PathVariable Long abbonamentoId,
            @PathVariable Long dettagliId) {
        AbbonamentoEntity updatedAbbonamento = abbonamentoService.associaDettagliAbbonamento(abbonamentoId, dettagliId);
        return new ResponseEntity<>(updatedAbbonamento, HttpStatus.OK);
    }
}

