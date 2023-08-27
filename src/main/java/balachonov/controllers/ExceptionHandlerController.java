package balachonov.controllers;

import balachonov.exceptions.PasswordGenerationAndCheckException;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
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
    public ResponseStatusException handleUserNotFoundException(EntityNotFoundException ex) {
        log.warn(LOG_ERR_EXCEPTION, ex.getMessage());
        return new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseStatusException handleValidationException(MethodArgumentNotValidException ex) {
        log.warn(LOG_ERR_EXCEPTION, ex.getMessage());
        return new ResponseStatusException(HttpStatus.BAD_REQUEST, getMessageForValidException(ex), ex);
    }

    @ExceptionHandler(PSQLException.class)
    public ResponseStatusException handlePSQLException(PSQLException ex) {
        log.warn(LOG_ERR_EXCEPTION, ex.getMessage());
        return new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), ex);
    }

    @ExceptionHandler(PasswordGenerationAndCheckException.class)
    public ResponseStatusException handlePasswordGenerationAndCheckException(PasswordGenerationAndCheckException ex) {
        log.warn(LOG_ERR_EXCEPTION, ex.getMessage());
        return new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ERR_PASSWORD_GENERATION_MESSAGE, ex);
    }

    @ExceptionHandler(MailException.class)
    public void handleMailException(MailException ex) {
        log.warn(LOG_ERR_EXCEPTION, ex.getMessage());
    }

    private String getMessageForValidException(MethodArgumentNotValidException ex) {
        String field = ex.getBindingResult().getFieldError().getField();
        String defaultMessage = ex.getBindingResult().getFieldError().getDefaultMessage();
        return format(ERR_VALID_MESSAGE, field, defaultMessage);
    }
}
