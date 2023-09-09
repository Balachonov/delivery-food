package balachonov.arguments.orders;

import balachonov.dto.requests.OrderRequest;
import balachonov.dto.responses.OrderResponse;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.List;
import java.util.stream.Stream;

import static balachonov.arguments.orders.InputOrder.*;

public class UpdatedOrder implements ArgumentsProvider {

    public static final OrderRequest ORDER_REQUEST_TEST = OrderRequest.builder()
            .owner(PERSON_TEST)
            .dishRequest(List.of())
            .description("example update description")
            .orderTime(ORDER_TIME)
            .build();

    public static final OrderResponse EXPECTED_ORDER_RESPONSE_TEST = OrderResponse.builder()
            .id(ID)
            .owner(EXPECTED_PERSON_RESPONSE_TEST)
            .dishResponses(List.of())
            .description("example update description")
            .orderTime(ORDER_TIME)
            .build();

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(Arguments.of(ORDER_REQUEST_TEST, ORDER_TEST,
                EXPECTED_ORDER_RESPONSE_TEST));
    }
}