package it.links.abbonamenti_domain.mapper;

import it.links.abbonamenti_domain.dto.AbbonamentoDTO;
import it.links.abbonamenti_domain.entity.AbbonamentoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AbbonamentoMapper {

    @Mapping(target = "utenteId", source = "utente.id")
    AbbonamentoDTO toDTO(AbbonamentoEntity abbonamento);

    @Mapping(target = "utente.id", source = "utenteId")
    AbbonamentoEntity toEntity(AbbonamentoDTO abbonamentoDTO);

    List<AbbonamentoDTO> convertToDTOList(List<AbbonamentoEntity> abbonamenti);
    List<AbbonamentoEntity> convertToEntityList(List<AbbonamentoDTO> abbonamentiDTO);
}
