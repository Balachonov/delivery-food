package balachonov.mappers;

import balachonov.dto.FoodDTO;
import balachonov.entities.Food;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodMapperDto {
    FoodMapperDto INSTANCE = Mappers.getMapper(FoodMapperDto.class);

    FoodDTO toDto(Food user);

    Food toEntity(FoodDTO userDTO);
}
