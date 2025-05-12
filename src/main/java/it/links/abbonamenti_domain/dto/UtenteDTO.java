package it.links.abbonamenti_domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UtenteDTO {
    private Long id;
    private String cognome;
    private String nome;
    private String email;
    private int ruoloId;
}
