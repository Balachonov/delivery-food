package balachonov.arguments.dishes;

import balachonov.dto.requests.DishRequest;
import balachonov.dto.responses.DishResponse;
import balachonov.entities.Dish;
import balachonov.enums.DishType;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import static balachonov.arguments.dishes.InputDish.DISH_TEST;
import static balachonov.arguments.dishes.InputDish.ID;

public class UpdatedDish implements ArgumentsProvider {

    public static final DishRequest DISH_REQUEST_TEST = DishRequest.builder()
            .name("test updated")
            .price(BigDecimal.valueOf(10))
            .description("example updated description")
            .type(DishType.COLD)
            .orderRequests(List.of())
            .build();

    public static final DishResponse EXPECTED_DISH_RESPONSE_TEST = DishResponse.builder()
            .id(ID)
            .name("test updated")
            .price(BigDecimal.valueOf(10))
            .description("example updated description")
            .type(DishType.COLD)
            .orderResponses(List.of())
            .build();

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(Arguments.of(DISH_REQUEST_TEST, DISH_TEST, EXPECTED_DISH_RESPONSE_TEST));
    }
}