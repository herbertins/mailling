package br.com.mailling.infra.mapper;

import br.com.mailling.domain.model.Address;
import br.com.mailling.infra.persistence.entity.AddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;


@Component
@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    Address toDomain(AddressEntity entity);

    AddressEntity toEntity(Address address);

}

