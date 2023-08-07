package balachonov.mappers;

import balachonov.entities.Basket;
import balachonov.entities.Dish;
import balachonov.enums.DishType;

import java.math.BigDecimal;
import java.util.List;

public class DishMapper {

    private static DishMapper dishMapper;

    public static DishMapper getDishMapper() {
        if (dishMapper == null) {
            dishMapper = new DishMapper();
        }
        return dishMapper;
    }

    public Dish buildDish(String name, BigDecimal price, String description, String type,
                          List<Basket> baskets, Integer deleted) {
        return Dish.builder()
                .name(name)
                .price(price)
                .description(description)
                .type(DishType.valueOf(type))
                .baskets(baskets)
                .deleted(deleted)
                .build();
    }

    public Dish buildDishById(String id, String name, BigDecimal price, String description, String type,
                          List<Basket> baskets, Integer deleted) {
        return Dish.builder()
                .id(id)
                .name(name)
                .price(price)
                .description(description)
                .type(DishType.valueOf(type))
                .baskets(baskets)
                .deleted(deleted)
                .build();
    }

    private DishMapper() {
    }
}