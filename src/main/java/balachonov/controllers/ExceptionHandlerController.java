package balachonov.controllers;

import com.google.i18n.phonenumbers.NumberParseException;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import static balachonov.util.Constants.*;
import static java.lang.String.format;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseStatusException handleUserNotFoundException(EntityNotFoundException exception) {
        log.warn(LOG_ERR_EXCEPTION, exception.getMessage());
        return new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseStatusException handleValidationException(MethodArgumentNotValidException exception) {
        log.warn(LOG_ERR_EXCEPTION, exception.getMessage());
        return new ResponseStatusException(HttpStatus.BAD_REQUEST, getMessageForValidException(exception), exception);
    }

    @ExceptionHandler(PSQLException.class)
    public ResponseStatusException handlePSQLException(PSQLException exception) {
        log.warn(LOG_ERR_EXCEPTION, exception.getMessage());
        return new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getLocalizedMessage(), exception);
    }

    @ExceptionHandler(NumberParseException.class)
    public ResponseStatusException handleNumberParseException(NumberParseException exception) {
        log.warn(LOG_ERR_EXCEPTION, exception.getMessage());
        return new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage(), exception);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseStatusException handleIllegalArgumentException(IllegalArgumentException exception) {
        log.warn(LOG_ERR_EXCEPTION, exception.getMessage());
        return new ResponseStatusException(HttpStatus.NOT_FOUND, ERR_PAGE_NOT_FOUND, exception);
    }

    @ExceptionHandler(UnsupportedOperationException.class)
    public void handleUnsupportedOperationException(UnsupportedOperationException exception) {
        log.warn(LOG_ERR_EXCEPTION, exception.getMessage());
    }

    @ExceptionHandler(MailException.class)
    public void handleMailException(MailException exception) {
        log.warn(LOG_ERR_EXCEPTION, exception.getMessage());
    }

    private String getMessageForValidException(MethodArgumentNotValidException exception) {
        return format(ERR_VALID_MESSAGE,
                StringUtils.defaultString(exception.getBindingResult().getFieldError().getField()),
                StringUtils.defaultString(exception.getBindingResult().getFieldError().getDefaultMessage()));
    }
}