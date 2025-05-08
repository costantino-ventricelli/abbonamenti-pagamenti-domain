package it.links.abbonamenti_domain.controller;

import it.links.abbonamenti_domain.dto.AbbonamentoDTO;
import it.links.abbonamenti_domain.service.AbbonamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AbbonamentoController {

    @Autowired
    private AbbonamentoService abbonamentoService;

    // Creazione di un nuovo abbonamento
    @PostMapping
    public ResponseEntity<AbbonamentoDTO> createAbbonamento(@RequestBody AbbonamentoDTO abbonamentoDTO) {
        AbbonamentoDTO newAbbonamento = abbonamentoService.createAbbonamento(abbonamentoDTO);
        return new ResponseEntity<>(newAbbonamento, HttpStatus.CREATED);
    }

    // Recupero di tutti gli abbonamenti
    @GetMapping
    public ResponseEntity<List<AbbonamentoDTO>> getAllAbbonamenti() {
        List<AbbonamentoDTO> abbonamenti = abbonamentoService.getAllAbbonamenti();
        return new ResponseEntity<>(abbonamenti, HttpStatus.OK);
    }

    // Recupero di un abbonamento per ID
    @GetMapping("/{id}")
    public ResponseEntity<AbbonamentoDTO> getAbbonamentoById(@PathVariable Long id) {
        AbbonamentoDTO abbonamento = abbonamentoService.getAbbonamentoById(id);
        return ResponseEntity.ok(abbonamento);
    }

    // Aggiornamento di un abbonamento
    @PutMapping("/{id}")
    public ResponseEntity<AbbonamentoDTO> updateAbbonamento(@PathVariable Long id, @RequestBody AbbonamentoDTO abbonamentoDTO) {
        AbbonamentoDTO updatedAbbonamento = abbonamentoService.updateAbbonamento(id, abbonamentoDTO);
        return new ResponseEntity<>(updatedAbbonamento, HttpStatus.OK);
    }

    // Eliminazione di un abbonamento
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAbbonamento(@PathVariable Long id) {
        abbonamentoService.deleteAbbonamento(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Associazione di un utente a un abbonamento
    @PostMapping("/{abbonamentoId}/utente/{utenteId}")
    public ResponseEntity<AbbonamentoDTO> associaUtenteAlAbbonamento(
            @PathVariable Long abbonamentoId,
            @PathVariable Long utenteId) {
        AbbonamentoDTO updatedAbbonamento = abbonamentoService.associaUtenteAlAbbonamento(abbonamentoId, utenteId);
        return new ResponseEntity<>(updatedAbbonamento, HttpStatus.OK);
    }
}
