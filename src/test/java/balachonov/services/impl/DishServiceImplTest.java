package balachonov.services.impl;

import balachonov.arguments.dishes.*;
import balachonov.arguments.orders.*;
import balachonov.dto.requests.DishRequest;
import balachonov.dto.requests.OrderRequest;
import balachonov.dto.responses.DishResponse;
import balachonov.dto.responses.OrderResponse;
import balachonov.entities.Dish;
import balachonov.entities.Order;
import balachonov.mappers.DishMapperDto;
import balachonov.repositories.DishRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.Optional.ofNullable;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@DisplayName("DishService test")
class DishServiceImplTest {

    @Mock
    private DishRepository dishRepository;

    @Autowired
    private DishMapperDto dishMapper;

    @InjectMocks
    private DishServiceImpl dishServiceImpl;

    @BeforeEach
    void init() {
        dishServiceImpl = new DishServiceImpl(dishRepository, dishMapper);
    }

    @ParameterizedTest
    @ArgumentsSource(InputDish.class)
    void saveDish(DishRequest dishRequest, Dish dish, DishResponse expecedDishResponse) {
        when(dishRepository.save(any(Dish.class))).thenReturn(dish);
        DishResponse actualDishResponse = dishServiceImpl.saveDish(dishRequest);
        assertEquals(expecedDishResponse, actualDishResponse);
    }

    @ParameterizedTest
    @ArgumentsSource(OutputDish.class)
    void getDishById(Dish dish, DishResponse expecedDishResponse) {
        when(dishRepository.findById(any(UUID.class))).thenReturn(ofNullable(dish));
        DishResponse actualDishResponse = dishServiceImpl.getDishById(dish.getId());
        assertEquals(expecedDishResponse, actualDishResponse);
    }

    @ParameterizedTest
    @ArgumentsSource(OutputDish.class)
    void getDishByName(Dish dish, DishResponse expecedDishResponse) {
        when(dishRepository.findByName(any(String.class))).thenReturn(ofNullable(dish));
        DishResponse actualDishResponse = dishServiceImpl.getDishByName(dish.getName());
        assertEquals(expecedDishResponse, actualDishResponse);
    }

    @ParameterizedTest
    @ArgumentsSource(UpdatedDish.class)
    void updateDish(DishRequest dishRequest, Dish dish, DishResponse expecedDishResponse) {
        when(dishRepository.findById(any(UUID.class))).thenReturn(ofNullable(dish));
        when(dishRepository.save(any(Dish.class))).thenReturn(dish);
        DishResponse actualDishResponse = dishServiceImpl.updateDish(dishRequest, dish.getId());
        assertEquals(expecedDishResponse, actualDishResponse);
    }

    @ParameterizedTest
    @ArgumentsSource(OutputDish.class)
    void getDishes(Dish dish, DishResponse expecedDishResponse) {
        when(dishRepository.findAll()).thenReturn(List.of(dish));
        List<DishResponse> actualDishResponse = dishServiceImpl.getDishes();
        assertEquals(List.of(expecedDishResponse), actualDishResponse);
    }

    @ParameterizedTest
    @ArgumentsSource(InvalidDish.class)
    void getDishByIdException(Dish dish) {
        when(dishRepository.findById(any(UUID.class))).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, (Executable) dishServiceImpl.getDishById(dish.getId()));
    }

    @ParameterizedTest
    @ArgumentsSource(InvalidDish.class)
    void getDishByNameException(Dish dish) {
        when(dishRepository.findByName(any(String.class))).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, (Executable) dishServiceImpl.getDishByName(dish.getName()));
    }

    @ParameterizedTest
    @ArgumentsSource(InvalidUpdatedDish.class)
    void updateOrderException(DishRequest dishRequest, UUID id) {
        when(dishRepository.findById(any(UUID.class))).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, (Executable) dishServiceImpl.updateDish(dishRequest, id));
    }
}