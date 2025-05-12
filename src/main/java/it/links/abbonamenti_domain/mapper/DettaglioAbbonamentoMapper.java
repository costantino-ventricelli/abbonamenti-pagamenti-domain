package it.links.abbonamenti_domain.mapper;

import it.links.abbonamenti_domain.dto.DettaglioAbbonamentoDTO;
import it.links.abbonamenti_domain.entity.DettaglioAbbonamentoEntity;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DettaglioAbbonamentoMapper{

    DettaglioAbbonamentoDTO toDto(DettaglioAbbonamentoEntity entity);

    DettaglioAbbonamentoEntity toEntity(DettaglioAbbonamentoDTO dto);

    List<DettaglioAbbonamentoDTO> convertToDTOList(List<DettaglioAbbonamentoEntity> dettagli);
}

