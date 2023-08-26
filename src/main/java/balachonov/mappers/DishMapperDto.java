package balachonov.mappers;

import balachonov.dto.responses.DishDtoResponse;
import balachonov.entities.Dish;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import static balachonov.util.Constants.*;

@Mapper(uses = {BasketMapperDto.class}, componentModel = SPRING)
public interface DishMapperDto {

    @Mapping(source = DISH_BASKETS, target = BASKETS_DTO)
    DishDtoResponse toDto(Dish dish);

    Dish toEntity(DishDtoResponse dishDTO);

    void updateEntity(DishDtoResponse dishDTO, @MappingTarget Dish dish);
}
