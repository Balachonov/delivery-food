package balachonov.mappers;

import balachonov.dto.FoodDTO;
import balachonov.entities.Food;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodMapperDto {
    FoodMapperDto INSTANCE_FOOD_DTO = Mappers.getMapper(FoodMapperDto.class);

    FoodDTO toDto(Food user);

    Food toEntity(FoodDTO userDTO);

    void updateEntity(FoodDTO foodDTO, @MappingTarget Food food);
}
