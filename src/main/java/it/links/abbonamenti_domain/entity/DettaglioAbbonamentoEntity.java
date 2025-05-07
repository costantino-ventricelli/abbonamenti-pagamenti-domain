package it.links.abbonamenti_domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dettagli_abbonamento")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DettaglioAbbonamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "abbonamento_id")
    private AbbonamentoEntity abbonamento;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "costo")
    private double costo;

    @Column(name = "anno_attivazione")
    private int annoAttivazione;
}
