package balachonov.arguments.dishes;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.UUID;
import java.util.stream.Stream;

import static balachonov.arguments.dishes.InputDish.DISH_REQUEST_TEST;

public class InvalidUpdatedDish implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(Arguments.of(DISH_REQUEST_TEST, UUID.randomUUID()));
    }
}