package balachonov.repositories;

import balachonov.entities.Food;

import java.util.List;
import java.util.Optional;

public class FoodRepositoryImpl implements FoodRepository {
    @Override
    public Food create(Food food) {
        return null;
    }

    @Override
    public Optional<Food> getFoodById(String idFood) {
        return Optional.empty();
    }

    @Override
    public Optional<Food> getFoodByName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<Food> updateFood(String foodId, Food food) {
        return Optional.empty();
    }

    @Override
    public List<Food> getAllFood() {
        return null;
    }

    @Override
    public Optional<Food> deleteFood(String idFood) {
        return Optional.empty();
    }
}
