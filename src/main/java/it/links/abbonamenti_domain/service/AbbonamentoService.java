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

    public AbbonamentoDTO createAbbonamento(AbbonamentoDTO abbonamentoDTO) {
        AbbonamentoEntity abbonamentoEntity = abbonamentoMapper.toEntity(abbonamentoDTO);
        AbbonamentoEntity savedEntity = abbonamentoRepository.save(abbonamentoEntity);
        return abbonamentoMapper.toDto(savedEntity);
    }

    public List<AbbonamentoDTO> getAllAbbonamenti() {
        List<AbbonamentoEntity> abbonamenti = abbonamentoRepository.findAll();
        return abbonamentoMapper.convertToDTOList(abbonamenti);
    }

    public AbbonamentoDTO getAbbonamentoById(Long id) {
        return abbonamentoRepository.findById(id)
                .map(abbonamentoMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Abbonamento non trovato!"));
    }

    public AbbonamentoDTO updateAbbonamento(Long id, AbbonamentoDTO abbonamentoDTO) {
        if (abbonamentoRepository.existsById(id)) {
            AbbonamentoEntity abbonamentoEntity = abbonamentoMapper.toEntity(abbonamentoDTO);
            abbonamentoEntity.setId(id);
            AbbonamentoEntity updatedEntity = abbonamentoRepository.save(abbonamentoEntity);
            return abbonamentoMapper.toDto(updatedEntity);
        } else {
            throw new RuntimeException("Abbonamento non trovato!");
        }
    }

    public void deleteAbbonamento(Long id) {
        if (abbonamentoRepository.existsById(id)) {
            abbonamentoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Abbonamento non trovato!");
        }
    }

    public AbbonamentoDTO associaUtenteAlAbbonamento(Long abbonamentoId, Long utenteId) {
        AbbonamentoEntity abbonamento = abbonamentoRepository.findById(abbonamentoId)
                .orElseThrow(() -> new RuntimeException("Abbonamento non trovato!"));
        UtenteEntity utente = utenteRepository.findById(utenteId)
                .orElseThrow(() -> new RuntimeException("Utente non trovato!"));

        abbonamento.setUtente(utente);
        AbbonamentoEntity updatedAbbonamento = abbonamentoRepository.save(abbonamento);
        return abbonamentoMapper.toDto(updatedAbbonamento);
    }
}
