package balachonov.arguments.persons;

import balachonov.dto.requests.PersonRequest;
import balachonov.dto.responses.PersonResponse;
import balachonov.entities.Person;
import balachonov.enums.PersonRole;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class InputPerson implements ArgumentsProvider {

    public static final UUID ID = UUID.randomUUID();

    public static final Person PERSON_TEST = Person.builder()
            .id(ID)
            .firstName("personTest")
            .lastName("personTest")
            .email("test@test.com")
            .telephone("+375293274890")
            .password("12345678")
            .role(PersonRole.USER)
            .orders(List.of())
            .build();

    public static final PersonRequest PERSON_REQUEST_TEST = PersonRequest.builder()
            .firstName("personRequestTest")
            .lastName("personRequestTest")
            .email("test@test.com")
            .password("123345678")
            .orderRequests(List.of())
            .build();

    public static final PersonResponse EXPECTED_PERSON_RESPONSE_TEST = PersonResponse.builder()
            .id(ID)
            .firstName("personTest")
            .lastName("personTest")
            .email("test@test.com")
            .telephone("+375293274890")
            .password("12345678")
            .role(PersonRole.USER)
            .orderResponses(List.of())
            .build();

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(Arguments.of(PERSON_REQUEST_TEST, PERSON_TEST,
                EXPECTED_PERSON_RESPONSE_TEST));
    }
}