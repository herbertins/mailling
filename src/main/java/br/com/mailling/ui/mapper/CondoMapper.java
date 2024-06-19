package br.com.mailling.ui.mapper;

import br.com.mailling.domain.model.Condo;
import br.com.mailling.domain.model.CondoModel;
import br.com.mailling.domain.model.CondoType;
import br.com.mailling.ui.dto.Request;
import br.com.mailling.ui.dto.Response;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CondoMapper {

    CondoMapper INSTANCE = Mappers.getMapper(CondoMapper.class);

    @Mapping(source = "model", target = "model", qualifiedByName = "codeToCondoModel")
    @Mapping(source = "type", target = "type", qualifiedByName = "codeToCondoType")
    Condo toDomain(final Request request);

    @Mapping(source = "model.code", target = "model.code")
    @Mapping(source = "type.code", target = "type.code")
    @Mapping(source = "model.description", target = "model.description")
    @Mapping(source = "type.description", target = "type.description")
    Response toDto(final Condo entity);

    List<Response> toDto(final List<Condo> entity);

    @Named("codeToCondoModel")
    static CondoModel codeToCondoModel(String value) {
        return value != null ? CondoModel.fromCode(value) : null;
    }

    @Named("codeToCondoType")
    static CondoType codeToCondoType(String value) {
        return value != null ? CondoType.fromCode(value) : null;
    }
}