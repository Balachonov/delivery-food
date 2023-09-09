package balachonov.arguments.persons;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.UUID;
import java.util.stream.Stream;

import static balachonov.arguments.persons.InputPerson.PERSON_TEST;

public class InvalidPerson implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(Arguments.of(PERSON_TEST.setId(UUID.randomUUID())));
    }
}