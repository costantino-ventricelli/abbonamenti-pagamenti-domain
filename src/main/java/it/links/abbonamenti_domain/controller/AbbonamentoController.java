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

    @PostMapping
    public ResponseEntity<AbbonamentoDTO> createAbbonamento(@RequestBody AbbonamentoDTO abbonamentoDTO) {
        AbbonamentoDTO newAbbonamento = abbonamentoService.createAbbonamento(abbonamentoDTO);
        return new ResponseEntity<>(newAbbonamento, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AbbonamentoDTO>> getAllAbbonamenti() {
        List<AbbonamentoDTO> abbonamenti = abbonamentoService.getAllAbbonamenti();
        return new ResponseEntity<>(abbonamenti, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AbbonamentoDTO> getAbbonamentoById(@PathVariable Long id) {
        AbbonamentoDTO abbonamento = abbonamentoService.getAbbonamentoById(id);
        return ResponseEntity.ok(abbonamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AbbonamentoDTO> updateAbbonamento(@PathVariable Long id, @RequestBody AbbonamentoDTO abbonamentoDTO) {
        AbbonamentoDTO updatedAbbonamento = abbonamentoService.updateAbbonamento(id, abbonamentoDTO);
        return new ResponseEntity<>(updatedAbbonamento, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAbbonamento(@PathVariable Long id) {
        abbonamentoService.deleteAbbonamento(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{abbonamentoId}/utente/{utenteId}")
    public ResponseEntity<AbbonamentoDTO> associaUtenteAlAbbonamento(
            @PathVariable Long abbonamentoId,
            @PathVariable Long utenteId) {
        AbbonamentoDTO updatedAbbonamento = abbonamentoService.associaUtenteAlAbbonamento(abbonamentoId, utenteId);
        return new ResponseEntity<>(updatedAbbonamento, HttpStatus.OK);
    }
}
