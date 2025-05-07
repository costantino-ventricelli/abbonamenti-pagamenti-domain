package it.links.abbonamenti_domain.service;

import it.links.abbonamenti_domain.dto.AbbonamentoDTO;
import it.links.abbonamenti_domain.entity.AbbonamentoEntity;
import it.links.abbonamenti_domain.entity.DettaglioAbbonamentoEntity;
import it.links.abbonamenti_domain.entity.UtenteEntity;
import it.links.abbonamenti_domain.repository.AbbonamentoRepository;
import it.links.abbonamenti_domain.repository.DettaglioAbbonamentoRepository;
import it.links.abbonamenti_domain.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbbonamentoService {

    @Autowired
    private AbbonamentoRepository abbonamentoRepository;

    @Autowired
    private DettaglioAbbonamentoRepository dettagliAbbonamentoRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    // Creazione di un nuovo abbonamento
    public AbbonamentoEntity createAbbonamento(AbbonamentoEntity abbonamento) {
        return abbonamentoRepository.save(abbonamento);
    }

    // Recupero di tutti gli abbonamenti
    public List<AbbonamentoEntity> getAllAbbonamenti() {
        return abbonamentoRepository.findAll();
    }

    // Recupero di un abbonamento per id
    public Optional<AbbonamentoEntity> getAbbonamentoById(Long id) {
        return abbonamentoRepository.findById(id);
    }

    // Aggiornamento di un abbonamento
    public AbbonamentoEntity updateAbbonamento(Long id, AbbonamentoEntity abbonamento) {
        if (abbonamentoRepository.existsById(id)) {
            abbonamento.setId(id);
            return abbonamentoRepository.save(abbonamento);
        } else {
            throw new RuntimeException("Abbonamento non trovato!");
        }
    }

    // Eliminazione di un abbonamento
    public void deleteAbbonamento(Long id) {
        if (abbonamentoRepository.existsById(id)) {
            abbonamentoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Abbonamento non trovato!");
        }
    }

    // Metodo per associare un abbonamento a un utente
    public AbbonamentoEntity associaUtenteAlAbbonamento(Long abbonamentoId, Long utenteId) {
        AbbonamentoEntity abbonamento = abbonamentoRepository.findById(abbonamentoId)
                .orElseThrow(() -> new RuntimeException("Abbonamento non trovato!"));
        UtenteEntity utente = utenteRepository.findById(utenteId)
                .orElseThrow(() -> new RuntimeException("Utente non trovato!"));

        abbonamento.setUtente(utente);
        return abbonamentoRepository.save(abbonamento);
    }

    // Metodo per associare dettagli abbonamento a un abbonamento
    public AbbonamentoEntity associaDettagliAbbonamento(Long abbonamentoId, Long dettagliId) {
        AbbonamentoEntity abbonamento = abbonamentoRepository.findById(abbonamentoId)
                .orElseThrow(() -> new RuntimeException("Abbonamento non trovato!"));

        DettaglioAbbonamentoEntity dettaglioAbbonamento = dettagliAbbonamentoRepository.findById(dettagliId)
                .orElseThrow(() -> new RuntimeException("Dettagli abbonamento non trovati!"));

        dettaglioAbbonamento.setAbbonamento(abbonamento); // Associazione lato DettaglioAbbonamento
        dettagliAbbonamentoRepository.save(dettaglioAbbonamento); // Salva l'associazione

        // Ritorna l'abbonamento aggiornato, con i dettagli sincronizzati
        return abbonamentoRepository.findById(abbonamentoId)
                .orElseThrow(() -> new RuntimeException("Abbonamento non trovato dopo il salvataggio!"));
    }

}

