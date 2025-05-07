package it.links.abbonamenti_domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DettaglioAbbonamentoDTO {
    private Long id;
    private Long abbonamentoId;
    private String tipo;
    private double costo;
    private int annoAttivazione;
}
