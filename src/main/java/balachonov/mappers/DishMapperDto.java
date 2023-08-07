package balachonov.mappers;

import balachonov.dto.DishDto;
import balachonov.entities.Dish;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import static balachonov.util.Constants.*;

@Mapper(uses = {BasketMapperDto.class})
public interface DishMapperDto {
    DishMapperDto dishMapperDto = Mappers.getMapper(DishMapperDto.class);

    @Mapping(source = DISH_BASKETS, target = BASKETS)
    DishDto toDto(Dish dish);

    Dish toEntity(DishDto dishDTO);

    void updateEntity(DishDto dishDTO, @MappingTarget Dish dish);
}
