package br.com.mailling.application.mappers;

import br.com.mailling.application.dto.Request;
import br.com.mailling.application.dto.Response;
import br.com.mailling.domain.model.Condo;
import br.com.mailling.domain.model.CondoModel;
import br.com.mailling.domain.model.CondoType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CondoMapper {

    CondoMapper INSTANCE = Mappers.getMapper(CondoMapper.class);

    @Mapping(source = "model", target = "model", qualifiedByName = "codeToCondominiumModel")
    @Mapping(source = "type", target = "type", qualifiedByName = "codeToCondominiumType")
    Condo toDomain(final Request request);

    Response toResponse(final Condo entity);

    List<Response> toResponse(final List<Condo> entity);

    @Named("condominiumModelToCode")
    static String condominiumModelToCode(CondoModel obj) {
        return obj != null ? obj.getCode() : null;
    }

    @Named("codeToCondominiumModel")
    static CondoModel codeToCondominiumModel(String value) {
        return value != null ? CondoModel.fromCode(value) : null;
    }

    @Named("condominiumTypeToCode")
    static String condominiumTypeToCode(CondoType obj) {
        return obj != null ? obj.getCode() : null;
    }

    @Named("codeToCondominiumType")
    static CondoType codeToCondominiumType(String value) {
        return value != null ? CondoType.fromCode(value) : null;
    }
}
