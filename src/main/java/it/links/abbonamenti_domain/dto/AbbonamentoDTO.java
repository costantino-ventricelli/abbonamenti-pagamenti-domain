package it.links.abbonamenti_domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbbonamentoDTO {
    private Long id;
    private Long utenteId;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private String tipo;
    private double costo;
    private int annoAttivazione;
}