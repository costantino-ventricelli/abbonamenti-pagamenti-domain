package it.links.abbonamenti_domain.mapper;

import it.links.abbonamenti_domain.dto.AbbonamentoDTO;
import it.links.abbonamenti_domain.entity.AbbonamentoEntity;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface AbbonamentoMapper {

    AbbonamentoDTO toDto(AbbonamentoEntity entity);

    AbbonamentoEntity toEntity(AbbonamentoDTO dto);

    List<AbbonamentoDTO> convertToDTOList(List<AbbonamentoEntity> abbonamenti);
}


