package it.links.abbonamenti_domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbbonamentoDTO {
    private Long id;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private UtenteDTO utente;
    private List<DettaglioAbbonamentoDTO> dettagli;

}