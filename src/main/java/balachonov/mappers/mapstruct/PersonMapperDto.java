package balachonov.mappers.mapstruct;

import balachonov.dto.PersonDto;
import balachonov.entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import static balachonov.util.Constants.*;

@Mapper(uses = {AddressMapperDto.class, BasketMapperDto.class})
public interface PersonMapperDto {
    PersonMapperDto personMapperDto = Mappers.getMapper(PersonMapperDto.class);

    @Mapping(target = PASSWORD, ignore = true)
    @Mapping(target = SALT, ignore = true)
    @Mapping(target = ROLE, ignore = true)
    @Mapping(source = PERSON_ADDRESSES, target = ADDRESSES_DTO)
    @Mapping(source = PERSON_BASKETS, target = BASKETS_DTO)
    PersonDto toDto(Person person);

    @DoIgnore
    @Mapping(source = PERSON_ADDRESSES, target = ADDRESSES_DTO)
    @Mapping(source = PERSON_BASKETS, target = BASKETS_DTO)
    PersonDto toFullDto(Person person);

    Person toEntity(PersonDto personDTO);

    void updateEntity (PersonDto personDTO, @MappingTarget Person person);
}
