package it.links.abbonamenti_domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "abbonamenti")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbbonamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_inizio")
    private LocalDate dataInizio;

    @Column(name = "data_fine")
    private LocalDate dataFine;

    @ManyToOne
    @JoinColumn(name = "id_utente")
    private UtenteEntity utente;
}
