package balachonov.mappers;

import balachonov.dto.AddressDto;
import balachonov.entities.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import static balachonov.util.Constants.*;

@Mapper (uses = {PersonMapperDto.class})
public interface AddressMapperDto {

    AddressMapperDto addressMapperDto = Mappers.getMapper(AddressMapperDto.class);

    @Mapping(source = ADDRESS_PERSON, target = PERSONS)
    AddressDto toDto (Address Address);

    Address toEntity (AddressDto addressDTO);
    void updateEntity(AddressDto addressDTO, @MappingTarget Address address);
}
