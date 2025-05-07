package it.links.abbonamenti_domain.repository;

import it.links.abbonamenti_domain.entity.DettaglioAbbonamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DettaglioAbbonamentoRepository extends JpaRepository<DettaglioAbbonamentoEntity, Long> {

}
