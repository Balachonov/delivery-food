package balachonov.mappers;

import balachonov.dto.responses.AddressDtoResponse;
import balachonov.entities.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import static balachonov.util.Constants.*;

@Mapper(uses = {PersonMapperDto.class}, componentModel = SPRING)
public interface AddressMapperDto {

    @Mapping(source = ADDRESS_PERSONS, target = PERSONS_DTO)
    AddressDtoResponse toDto(Address address);

    Address toEntity(AddressDtoResponse addressDTO);

    void updateEntity(AddressDtoResponse addressDTO, @MappingTarget Address address);
}
