package balachonov.arguments.orders;

import balachonov.entities.Order;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static balachonov.arguments.orders.InputOrder.*;

public class InvalidOrder implements ArgumentsProvider {
    public static final Order ORDER_TEST = Order.builder()
            .id(UUID.randomUUID())
            .person(PERSON_TEST)
            .dishes(List.of())
            .description("example description")
            .orderTime(ORDER_TIME)
            .build();

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(Arguments.of(ORDER_TEST));
    }
}