package balachonov.arguments.persons;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.UUID;
import java.util.stream.Stream;

import static balachonov.arguments.persons.InputPerson.PERSON_REQUEST_TEST;

public class InvalidUpdatedPerson implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(Arguments.of(PERSON_REQUEST_TEST, UUID.randomUUID()));
    }
}