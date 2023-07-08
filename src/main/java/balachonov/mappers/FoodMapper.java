package balachonov.mappers;

import balachonov.entities.Food;
import balachonov.entities.FoodType;

public class FoodMapper {

    private static FoodMapper foodMapper;

    public static FoodMapper getFoodMapper() {
        if (foodMapper == null) {
            foodMapper = new FoodMapper();
        }
        return foodMapper;
    }

    public Food buildFood(String name, Float price, Float weight, String description, String composition,
                          String foodType) {
        return Food.builder()
                .name(name)
                .price(price)
                .weight(weight)
                .description(description)
                .composition(composition)
                .foodType(FoodType.valueOf(foodType))
                .build();
    }

    public Food buildFoodById(String idFood, String name, Float price, Float weight, String description,
                              String composition, String foodType) {
        return Food.builder()
                .idFood(idFood)
                .name(name)
                .price(price)
                .weight(weight)
                .description(description)
                .composition(composition)
                .foodType(FoodType.valueOf(foodType))
                .build();
    }
    private FoodMapper() {
    }
}