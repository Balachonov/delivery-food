package balachonov.arguments.dishes;

import balachonov.entities.Dish;
import balachonov.enums.DishType;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class InvalidDish implements ArgumentsProvider {

    public static final Dish DISH_TEST = Dish.builder()
            .id(UUID.randomUUID())
            .name("test")
            .price(BigDecimal.valueOf(10))
            .description("example description")
            .type(DishType.HOT)
            .orders(List.of())
            .build();

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(Arguments.of(DISH_TEST));
    }
}