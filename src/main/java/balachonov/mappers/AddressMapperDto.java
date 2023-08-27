package balachonov.mappers;

import balachonov.dto.responses.AddressResponse;
import balachonov.entities.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import static balachonov.util.Constants.*;

@Mapper(uses = {PersonMapperDto.class}, componentModel = SPRING)
public interface AddressMapperDto {

    @Mapping(source = ADDRESS_PERSONS, target = PERSONS_DTO)
    AddressResponse toDto(Address address);

    Address toEntity(AddressResponse addressDTO);

    void updateEntity(AddressResponse addressDTO, @MappingTarget Address address);
}