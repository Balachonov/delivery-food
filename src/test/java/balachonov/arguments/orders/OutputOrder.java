package balachonov.arguments.orders;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static balachonov.arguments.orders.InputOrder.EXPECTED_ORDER_RESPONSE_TEST;
import static balachonov.arguments.orders.InputOrder.ORDER_TEST;

public class OutputOrder implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(Arguments.of(ORDER_TEST, EXPECTED_ORDER_RESPONSE_TEST));
    }
}