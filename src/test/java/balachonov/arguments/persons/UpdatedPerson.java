package balachonov.arguments.persons;

import balachonov.dto.requests.PersonRequest;
import balachonov.dto.responses.PersonResponse;
import balachonov.enums.PersonRole;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.List;
import java.util.stream.Stream;

import static balachonov.arguments.persons.InputPerson.ID;
import static balachonov.arguments.persons.InputPerson.PERSON_TEST;

public class UpdatedPerson implements ArgumentsProvider {

    public static final PersonRequest PERSON_REQUEST_TEST = PersonRequest.builder()
            .firstName("personTestUpdated")
            .lastName("personTestUpdated")
            .email("testUpdate@testUpdate.com")
            .password("87654321")
            .orderRequests(List.of())
            .build();

    public static final PersonResponse EXPECTED_PERSON_RESPONSE_TEST = PersonResponse.builder()
            .id(ID)
            .firstName("personTestUpdated")
            .lastName("personTestUpdated")
            .email("testUpdate@testUpdate.com")
            .telephone("+375293274890")
            .password("87654321")
            .role(PersonRole.USER)
            .orderResponses(List.of())
            .build();

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(Arguments.of(PERSON_REQUEST_TEST, PERSON_TEST,
                EXPECTED_PERSON_RESPONSE_TEST));
    }
}