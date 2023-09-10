package balachonov.validators.anotations;

import balachonov.validators.PhoneNumberConstraintValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static balachonov.util.Constants.ERR_MESSAGE_PHONE_NUMBER;

/**
 * Annotation for validation of the telephone number of Belarus.
 * Use Google telephone number library.
 * Example: {@link balachonov.dto.requests.PersonRequest}
 */
@Documented
@Constraint(validatedBy = PhoneNumberConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {

    String message() default ERR_MESSAGE_PHONE_NUMBER;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}