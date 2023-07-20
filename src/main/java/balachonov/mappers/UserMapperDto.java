package balachonov.mappers;

import balachonov.dto.UserDTO;
import balachonov.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapperDto {
    UserMapperDto INSTANCE_USER_DTO = Mappers.getMapper(UserMapperDto.class);

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "salt", ignore = true)
    @Mapping(target = "userRole", ignore = true)
    UserDTO toDto(User user);

    UserDTO toFullDto(User user);

    User toEntity(UserDTO userDTO);

    void updateEntity (UserDTO userDTO, @MappingTarget User user);
}
