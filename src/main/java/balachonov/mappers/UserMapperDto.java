package balachonov.mappers;

import balachonov.dto.UserDTO;
import balachonov.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapperDto {
    UserMapperDto INSTANCE = Mappers.getMapper(UserMapperDto.class);
    UserDTO toDto(User user);

    User toEntity(UserDTO userDTO);

    void updateEntity (UserDTO userDTO, @MappingTarget User user);
}
