package balachonov.repositories;

import balachonov.entities.Food;
import balachonov.mappers.FoodMapper;
import balachonov.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static balachonov.util.Constants.*;

public class FoodRepositoryImpl implements FoodRepository {
    private final FoodMapper FOOD_MAPPER = new FoodMapper();
    @Override
    public Food create(Food food) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(SQL_CREATE_FOOD);
            statement.setString(1, food.getName());
            statement.setFloat(2, food.getPrice());
            statement.setFloat(3, food.getWeight());
            statement.setString(4, food.getDescription());
            statement.setString(5, food.getComposition());
            statement.setString(6, food.getFoodType().getTitle());
            statement.execute();
            return food;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Optional<Food> getFoodById(String idFood) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(SQL_GET_FOOD_BY_ID);
            statement.setString(1, idFood);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Food food = FOOD_MAPPER.buildFoodById(
                        resultSet.getString(SQL_ID_FOOD),
                        resultSet.getString(SQL_NAME),
                        resultSet.getFloat(SQL_PRICE),
                        resultSet.getFloat(SQL_WEIGHT),
                        resultSet.getString(SQL_DESCRIPTION),
                        resultSet.getString(SQL_COMPOSITION),
                        resultSet.getString(SQL_FOOD_TYPE)
                );
                return Optional.of(food);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Food> getFoodByName(String name) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(SQL_GET_FOOD_BY_NAME);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Food food = FOOD_MAPPER.buildFoodById(
                        resultSet.getString(SQL_ID_FOOD),
                        resultSet.getString(SQL_NAME),
                        resultSet.getFloat(SQL_PRICE),
                        resultSet.getFloat(SQL_WEIGHT),
                        resultSet.getString(SQL_DESCRIPTION),
                        resultSet.getString(SQL_COMPOSITION),
                        resultSet.getString(SQL_FOOD_TYPE)
                );
                return Optional.of(food);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Food> updateFood(String foodId, Food food) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(SQL_GET_FOOD_BY_ID);
            statement.setString(1, foodId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                PreparedStatement update = connection.prepareStatement(SQL_UPDATE_FOOD);
                update.setString(1, food.getName());
                update.setFloat(2, food.getPrice());
                update.setFloat(3, food.getWeight());
                update.setString(4, food.getDescription());
                update.setString(5, food.getComposition());
                update.setString(6, food.getFoodType().getTitle());
                update.setString(7, foodId);
                update.execute();
                return Optional.of(food);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public List<Food> getAllFood() {
        List<Food> foods = new ArrayList<>();
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(SQL_GET_ALL_FOOD);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Food food = FOOD_MAPPER.buildFoodById(
                        resultSet.getString(SQL_ID_FOOD),
                        resultSet.getString(SQL_NAME),
                        resultSet.getFloat(SQL_PRICE),
                        resultSet.getFloat(SQL_WEIGHT),
                        resultSet.getString(SQL_DESCRIPTION),
                        resultSet.getString(SQL_COMPOSITION),
                        resultSet.getString(SQL_FOOD_TYPE)
                );
                foods.add(food);
            }
            return foods;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Food> deleteFood(String idFood) {
        Optional<Food> optionalFood = getFoodById(idFood);
        if (!optionalFood.isPresent()) {
            return Optional.empty();
        }
        Food food = optionalFood.get();
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_FOOD);
            statement.setString(1, idFood);
            statement.execute();
            return Optional.of(food);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
