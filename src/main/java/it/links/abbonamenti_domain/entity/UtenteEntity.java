package it.links.abbonamenti_domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;
import java.util.List;

@Entity
@Table(name = "utenti")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UtenteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cognome;
    private String nome;
    private String password;
    private String email;
    private String percorsoFoto;

    @Column(name = "anno_assunzione")
    private Year annoAssunzione;

    @Column(name = "ruolo_id")
    private int ruoloId;

    @OneToMany(mappedBy = "utente")
    private List<AbbonamentoEntity> abbonamenti;
}
