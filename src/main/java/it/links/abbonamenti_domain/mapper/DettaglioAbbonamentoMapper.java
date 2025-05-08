package it.links.abbonamenti_domain.mapper;

import it.links.abbonamenti_domain.dto.DettaglioAbbonamentoDTO;
import it.links.abbonamenti_domain.entity.DettaglioAbbonamentoEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DettaglioAbbonamentoMapper {

    DettaglioAbbonamentoDTO toDTO(DettaglioAbbonamentoEntity dettaglioAbbonamento);

    DettaglioAbbonamentoEntity toEntity(DettaglioAbbonamentoDTO dettaglioAbbonamentoDTO);

    List<DettaglioAbbonamentoDTO> convertToDTOList(List<DettaglioAbbonamentoEntity> dettagliAbbonamento);
    List<DettaglioAbbonamentoEntity> convertToEntityList(List<DettaglioAbbonamentoDTO> dettagliAbbonamentoDTO);
}
