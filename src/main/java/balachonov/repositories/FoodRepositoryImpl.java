package balachonov.repositories;

import balachonov.dto.FoodDTO;
import balachonov.entities.Food;
import balachonov.entities.FoodType;

import java.util.List;
import java.util.Optional;

public class FoodRepositoryImpl implements FoodRepository {
    @Override
    public List<Food> readOrdersFoodByType(FoodType type) {
        return null;
    }

    @Override
    public Optional<Food> create(FoodDTO foodDTO) {
        return Optional.empty();
    }

    @Override
    public List<Food> readAll() {
        return null;
    }

    @Override
    public List<Food> readAllWithRestriction(String s) {
        return null;
    }

    @Override
    public Optional<Food> read(String s) {
        return Optional.empty();
    }

    @Override
    public Optional<Food> update(FoodDTO foodDTO) {
        return Optional.empty();
    }

    @Override
    public Optional<Food> delete(FoodDTO foodDTO) {
        return Optional.empty();
    }
}
