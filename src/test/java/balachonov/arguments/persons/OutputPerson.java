package balachonov.arguments.persons;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static balachonov.arguments.persons.InputPerson.EXPECTED_PERSON_RESPONSE_TEST;
import static balachonov.arguments.persons.InputPerson.PERSON_TEST;

public class OutputPerson implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(Arguments.of(PERSON_TEST, EXPECTED_PERSON_RESPONSE_TEST));
    }
}