package balachonov.repositories;

import balachonov.dto.DishDto;
import balachonov.entities.Dish;
import balachonov.enums.DishType;

import java.util.List;

public interface DishRepository extends GeneralOperation<String, Dish, DishDto> {
    List<Dish> readDishByType(DishType type);

    List<Dish> readArchiveDish();
}
