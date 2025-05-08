package it.links.abbonamenti_domain.mapper;

import it.links.abbonamenti_domain.dto.UtenteDTO;
import it.links.abbonamenti_domain.entity.UtenteEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UtenteMapper {

    UtenteDTO toDTO(UtenteEntity utente);

    UtenteEntity toEntity(UtenteDTO utenteDTO);

    List<UtenteDTO> convertToDTOList(List<UtenteEntity> utenti);
    List<UtenteEntity> convertToEntityList(List<UtenteDTO> utentiDTO);
}
