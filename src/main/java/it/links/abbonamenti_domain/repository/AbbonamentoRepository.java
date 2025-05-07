package it.links.abbonamenti_domain.repository;

import it.links.abbonamenti_domain.entity.AbbonamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbbonamentoRepository extends JpaRepository<AbbonamentoEntity, Long> {

}

