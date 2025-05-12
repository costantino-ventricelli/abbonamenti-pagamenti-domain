package it.links.abbonamenti_domain.mapper;

import it.links.abbonamenti_domain.dto.UtenteDTO;
import it.links.abbonamenti_domain.entity.UtenteEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UtenteMapper {

    // Mapping di UtenteEntity in UtenteDTO
    UtenteDTO toDto(UtenteEntity entity);

    // Mapping di UtenteDTO in UtenteEntity
    UtenteEntity toEntity(UtenteDTO dto);

    List<UtenteDTO> convertToDTOList(List<UtenteEntity> utenti);
}

