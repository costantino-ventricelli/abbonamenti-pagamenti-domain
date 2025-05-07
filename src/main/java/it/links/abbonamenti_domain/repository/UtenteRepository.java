package it.links.abbonamenti_domain.repository;

import it.links.abbonamenti_domain.entity.UtenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<UtenteEntity, Long> {

}

