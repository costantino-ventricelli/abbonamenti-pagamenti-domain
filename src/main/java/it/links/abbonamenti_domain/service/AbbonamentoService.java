package it.links.abbonamenti_domain.service;

import it.links.abbonamenti_domain.dto.AbbonamentoDTO;
import it.links.abbonamenti_domain.entity.AbbonamentoEntity;
import it.links.abbonamenti_domain.entity.UtenteEntity;
import it.links.abbonamenti_domain.mapper.AbbonamentoMapper;
import it.links.abbonamenti_domain.repository.AbbonamentoRepository;
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
    private UtenteRepository utenteRepository;

    @Autowired
    private AbbonamentoMapper abbonamentoMapper;

    // Creazione di un nuovo abbonamento
    public AbbonamentoDTO createAbbonamento(AbbonamentoDTO abbonamentoDTO) {
        AbbonamentoEntity abbonamentoEntity = abbonamentoMapper.toEntity(abbonamentoDTO);
        AbbonamentoEntity savedEntity = abbonamentoRepository.save(abbonamentoEntity);
        return abbonamentoMapper.toDTO(savedEntity);
    }

    // Recupero di tutti gli abbonamenti
    public List<AbbonamentoDTO> getAllAbbonamenti() {
        List<AbbonamentoEntity> abbonamenti = abbonamentoRepository.findAll();
        return abbonamentoMapper.convertToDTOList(abbonamenti);
    }

    // Recupero di un abbonamento per id
    public AbbonamentoDTO getAbbonamentoById(Long id) {
        AbbonamentoEntity abbonamento = abbonamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Abbonamento non trovato!"));
        return abbonamentoMapper.toDTO(abbonamento);
    }

    // Aggiornamento di un abbonamento
    public AbbonamentoDTO updateAbbonamento(Long id, AbbonamentoDTO abbonamentoDTO) {
        if (abbonamentoRepository.existsById(id)) {
            AbbonamentoEntity abbonamentoEntity = abbonamentoMapper.toEntity(abbonamentoDTO);
            abbonamentoEntity.setId(id); // Assicuriamoci che l'ID rimanga quello originale
            AbbonamentoEntity updatedEntity = abbonamentoRepository.save(abbonamentoEntity);
            return abbonamentoMapper.toDTO(updatedEntity);
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

    // Associazione di un utente a un abbonamento
    public AbbonamentoDTO associaUtenteAlAbbonamento(Long abbonamentoId, Long utenteId) {
        AbbonamentoEntity abbonamento = abbonamentoRepository.findById(abbonamentoId)
                .orElseThrow(() -> new RuntimeException("Abbonamento non trovato!"));
        UtenteEntity utente = utenteRepository.findById(utenteId)
                .orElseThrow(() -> new RuntimeException("Utente non trovato!"));

        abbonamento.setUtente(utente);
        AbbonamentoEntity updatedAbbonamento = abbonamentoRepository.save(abbonamento);
        return abbonamentoMapper.toDTO(updatedAbbonamento);
    }
}
