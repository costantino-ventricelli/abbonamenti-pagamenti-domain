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
    private String percorsoFoto;
    private int annoAssunzione;
    private int ruoloId;
}
