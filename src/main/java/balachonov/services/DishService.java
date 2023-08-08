package balachonov.services;

import balachonov.dto.DishDto;
import balachonov.entities.Dish;
import balachonov.enums.DishType;
import balachonov.repositories.GeneralOperation;

import java.util.List;

public interface DishService extends GeneralOperation<String, Dish, DishDto> {
       List<Dish> readDishByType(DishType type);
}
