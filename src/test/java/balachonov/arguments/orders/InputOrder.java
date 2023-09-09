package balachonov.arguments.orders;

import balachonov.dto.requests.OrderRequest;
import balachonov.dto.responses.OrderResponse;
import balachonov.dto.responses.PersonResponse;
import balachonov.entities.Order;
import balachonov.entities.Person;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class InputOrder implements ArgumentsProvider {

    public static final UUID ID = UUID.randomUUID();
    public static final LocalDateTime ORDER_TIME = LocalDateTime.now();

    public static final Person PERSON_TEST = Person.builder()
            .id(ID)
            .firstName("personTest")
            .lastName("personTest")
            .email("test@test.com")
            .telephone("+375293274890")
            .orders(List.of())
            .build();

    public static final PersonResponse EXPECTED_PERSON_RESPONSE_TEST = PersonResponse.builder()
            .id(ID)
            .firstName("personTest")
            .lastName("personTest")
            .email("test@test.com")
            .telephone("+375293274890")
            .orderResponses(List.of())
            .build();

    public static final Order ORDER_TEST = Order.builder()
            .id(ID)
            .person(PERSON_TEST)
            .dishes(List.of())
            .description("example description")
            .orderTime(ORDER_TIME)
            .build();

    public static final OrderRequest ORDER_REQUEST_TEST = OrderRequest.builder()
            .owner(PERSON_TEST)
            .dishRequest(List.of())
            .description("example description")
            .orderTime(ORDER_TIME)
            .build();

    public static final OrderResponse EXPECTED_ORDER_RESPONSE_TEST = OrderResponse.builder()
            .id(ID)
            .owner(EXPECTED_PERSON_RESPONSE_TEST)
            .dishResponses(List.of())
            .description("example description")
            .orderTime(ORDER_TIME)
            .build();

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(Arguments.of(ORDER_REQUEST_TEST, ORDER_TEST,
                EXPECTED_ORDER_RESPONSE_TEST));
    }
}