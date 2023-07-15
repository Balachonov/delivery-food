package balachonov.services;

import balachonov.entities.Food;
import balachonov.repositories.FoodRepository;

import java.util.List;
import java.util.Optional;

public class FoodServiceImpl implements FoodService {
    private static FoodServiceImpl foodServiceImpl;
    private final FoodRepository FOOD_REPOSITORY = new FoodRepositoryImpl();

    public static FoodServiceImpl getFoodServiceImpl() {
        if (foodServiceImpl == null) {
            foodServiceImpl = new FoodServiceImpl();
        }
        return foodServiceImpl;
    }

    @Override
    public Food create(Food food) {
        return FOOD_REPOSITORY.create(food);
    }

    @Override
    public Optional<Food> getFoodById(String idFood) {
        return FOOD_REPOSITORY.getFoodById(idFood);
    }

    @Override
    public Optional<Food> getFoodByName(String name) {
        return FOOD_REPOSITORY.getFoodByName(name);
    }

    @Override
    public Optional<Food> updateFood(String foodId, Food food) {
        return FOOD_REPOSITORY.updateFood(foodId, food);
    }

    @Override
    public List<Food> getAllFood() {
        return FOOD_REPOSITORY.getAllFood();
    }

    @Override
    public Optional<Food> deleteFood(String idFood) {
        return FOOD_REPOSITORY.deleteFood(idFood);
    }

    private FoodServiceImpl() {
    }
}
