package balachonov.aspects.anotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation to exclude logging method.
 * Example: {@link balachonov.controllers.PersonController}
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface SkipLog {
}