package br.com.mailling.infra.mapper;

import br.com.mailling.domain.model.Condo;
import br.com.mailling.domain.model.CondoModel;
import br.com.mailling.domain.model.CondoType;
import br.com.mailling.infra.persistence.entity.CondoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CondoMapper {

    CondoMapper INSTANCE = Mappers.getMapper(CondoMapper.class);

    @Mapping(source = "model", target = "model", qualifiedByName = "condoModelToCode")
    @Mapping(source = "type", target = "type", qualifiedByName = "condoTypeToCode")
    CondoEntity toEntity(final Condo domain);

    @Mapping(source = "model", target = "model", qualifiedByName = "codeToCondoModel")
    @Mapping(source = "type", target = "type", qualifiedByName = "codeToCondoType")
    Condo toDomain(final CondoEntity entity);

    List<Condo> toDomain(final List<CondoEntity> entity);


    @Named("condoModelToCode")
    static String condoModelToCode(CondoModel obj) {
        return obj != null ? obj.getCode() : null;
    }

    @Named("codeToCondoModel")
    static CondoModel codeToCondoModel(String value) {
        return value != null ? CondoModel.fromCode(value) : null;
    }

    @Named("condoTypeToCode")
    static String condoTypeToCode(CondoType obj) {
        return obj != null ? obj.getCode() : null;
    }

    @Named("codeToCondoType")
    static CondoType codeToCondoType(String value) {
        return value != null ? CondoType.fromCode(value) : null;
    }

}
