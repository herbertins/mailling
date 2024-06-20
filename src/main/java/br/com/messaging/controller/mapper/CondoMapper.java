package br.com.messaging.controller.mapper;

import br.com.messaging.controller.dto.CondoResponseDTO;
import br.com.messaging.domain.model.Condo;
import br.com.messaging.domain.model.valueobject.CondoModel;
import br.com.messaging.domain.model.valueobject.CondoType;
import br.com.messaging.controller.dto.CondoRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CondoMapper {

    CondoMapper INSTANCE = Mappers.getMapper(CondoMapper.class);

    @Mapping(source = "model", target = "model", qualifiedByName = "codeToCondoModel")
    @Mapping(source = "type", target = "type", qualifiedByName = "codeToCondoType")
    Condo toDomain(final CondoRequestDTO request);

    @Mapping(source = "model.code", target = "model.code")
    @Mapping(source = "type.code", target = "type.code")
    @Mapping(source = "model.description", target = "model.description")
    @Mapping(source = "type.description", target = "type.description")
    CondoResponseDTO toDto(final Condo condo);

    List<CondoResponseDTO> toDto(final List<Condo> model);

    @Named("codeToCondoModel")
    static CondoModel codeToCondoModel(String value) {
        return value != null ? CondoModel.fromCode(value) : null;
    }

    @Named("codeToCondoType")
    static CondoType codeToCondoType(String value) {
        return value != null ? CondoType.fromCode(value) : null;
    }
}
