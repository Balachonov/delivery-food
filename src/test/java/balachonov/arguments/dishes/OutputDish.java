package balachonov.arguments.dishes;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static balachonov.arguments.dishes.InputDish.DISH_TEST;
import static balachonov.arguments.dishes.InputDish.EXPECTED_DISH_RESPONSE_TEST;

public class OutputDish implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(Arguments.of(DISH_TEST, EXPECTED_DISH_RESPONSE_TEST));
    }
}